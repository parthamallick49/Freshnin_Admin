package com.freshnin.adminapplication.activity;

import static android.media.CamcorderProfile.get;

import static com.theartofdev.edmodo.cropper.CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.callbacks.ImageUploadCallbacks;
import com.freshnin.adminapplication.databinding.ActivityCreateNewSessionBinding;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.model.ModelUploaInfo;
import com.freshnin.adminapplication.model.ModelUploadResponse;
import com.freshnin.adminapplication.tools.ProgressRequestBody;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActivityCreateNewSession extends AppCompatActivity implements ImageUploadCallbacks {
    public static final int EXTERNAL_STORAGE_CODE = 222;
    private static final int PIC_PHOTO = 123;
    private static final String TAG = "ActivityCreateNewSession";
    private ActivityCreateNewSessionBinding binding;
    final Calendar myCalendar= Calendar.getInstance();


    Uri pickedPhotoUri;
    File filePhoto;
    boolean isImageSelected = false;
    String coverImageLink="";
    Dialog dialogLoading;
    ViewModelAdminApp viewModelAdminApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCreateNewSessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.acnsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        DatePickerDialog.OnDateSetListener sessionStart = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                sessionStartDate();
            }
        };

        DatePickerDialog.OnDateSetListener sessionEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                sessionEndDate();
            }
        };


        binding.acnsEtProductSessionStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ActivityCreateNewSession.this,sessionStart,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        binding.acnsEtProductSessionEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ActivityCreateNewSession.this,sessionEnd,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        binding.acnsFoodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requestStoragePermission()) {
                    getImageFromAlbum(PIC_PHOTO);
                }
            }
        });

        binding.acnsBtnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(filePhoto!=null){
                    uploadPhoto(filePhoto);
                }
            }
        });

        binding.acnsBtnCreateSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.acnsEtProductName.getText().toString().isEmpty() ||
                   binding.acnsEtProductDiscription.getText().toString().isEmpty()||
                   binding.acnsEtProductUnitPrice.getText().toString().isEmpty() ||
                   binding.acnsEtProductUnitWeight.getText().toString().isEmpty()||
                  binding.acnsEtProductSessionStartDate.getText().toString().isEmpty()||
                  binding.acnsEtProductSessionEndDate.getText().toString().isEmpty()||coverImageLink.isEmpty()){

                }else{
                    createNewPreOrderItem(new ModelPreOrder(
                         Tools.generate9DigitDeliveryID("preOrder"),
                            binding.acnsEtProductName.getText().toString(),
                            binding.acnsEtProductDiscription.getText().toString(),
                            coverImageLink,
                            Integer.parseInt(binding.acnsEtProductUnitPrice.getText().toString()),
                            Integer.parseInt(binding.acnsEtProductUnitWeight.getText().toString()),
                            binding.acnsEtProductSessionStartDate.getText().toString(),
                            binding.acnsEtProductSessionEndDate.getText().toString(),
                            1
                    ));
                }
            }
        });
    }

    private void init(){
        setSupportActionBar(binding.acnsToolbar);
        getSupportActionBar().setTitle("Create New Session");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityCreateNewSession.this);

        binding.acnsBtnCreateSession.setEnabled(false);

    }

    private void sessionStartDate(){
        String myFormat="dd-MM-yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.acnsEtProductSessionStartDate.setText(dateFormat.format(myCalendar.getTime()));
                /*myCalendar.getTime().getDay()+"-"+myCalendar.getTime().getMonth()+"-"+myCalendar.getTime().getYear());*/

    }

    private void sessionEndDate(){
        String myFormat="dd-MM-yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.acnsEtProductSessionEndDate.setText(dateFormat.format(myCalendar.getTime()));
               /* myCalendar.getTime().getDay()+"-"+myCalendar.getTime().getMonth()+"-"+myCalendar.getTime().getYear());*/
    }

    void createNewPreOrderItem(ModelPreOrder order){
        dialogLoading.show();
        viewModelAdminApp.createNewPreOrderItem(order).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                if(modelResponse!=null && modelResponse.getResponse()==1){
                    dialogLoading.dismiss();
                    onBackPressed();
                    Toast.makeText(ActivityCreateNewSession.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityCreateNewSession.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    //upload image related
    private void uploadPhoto(File file) {
        if (file != null) {
            dialogLoading.show();
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, "image", ActivityCreateNewSession.this);
            viewModelAdminApp.uploadPreOrderItemImage(file, new ModelUploaInfo(Tools.generate9DigitDeliveryID("preorderitem")),progressRequestBody)
                    .observe(this, new Observer<ModelUploadResponse>() {
                        @Override
                        public void onChanged(ModelUploadResponse modelUploadResponse) {
                            if(modelUploadResponse==null){
                                dialogLoading.dismiss();
                                Toast.makeText(ActivityCreateNewSession.this, "Photo Upload Failed!!", Toast.LENGTH_SHORT).show();
                            }else if (modelUploadResponse.getMessage().equals("Uploaded successfuly")){
                                dialogLoading.dismiss();
                                coverImageLink=modelUploadResponse.getLink();
                                binding.acnsBtnCreateSession.setEnabled(true);
                            }
                        }
                    });
        } else {
            Toast.makeText(this, "Select Photo First", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean requestStoragePermission() {
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "requestStoragePermission: sob permission ase");
            return true;
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_CODE);
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: permissions size=" + permissions.length + "grand results size:" + grantResults.length);
        if (requestCode == EXTERNAL_STORAGE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "onRequestPermissionsResult: permission granted.");
                getImageFromAlbum(PIC_PHOTO);
            } else {
                Toast.makeText(ActivityCreateNewSession.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void getImageFromAlbum(int CODE) {
        /*binding.layoutUploadPhoto.imageResulationRequ.setVisibility(View.GONE);
        binding.layoutUploadPhoto.imageSizeRequ.setVisibility(View.GONE);*/
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PIC_PHOTO:
                if (resultCode == RESULT_OK) {
                    isImageSelected = true;
                    pickedPhotoUri = data.getData();
                    cropImage(pickedPhotoUri);
                }
                Log.d(TAG, "onActivityResult:PIC_PHOTO ");
                break;
        }

        if (requestCode == CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                pickedPhotoUri = result.getUri();
                filePhoto=new File(pickedPhotoUri.getPath());
                binding.acnsFoodImage.setImageURI(pickedPhotoUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Log.d(TAG, "onActivityResult: crop error:" + error.getMessage());
            }
        }

    }


    private void cropImage(Uri pickedPhotoUri) {
        CropImage.activity(pickedPhotoUri)
                .setFixAspectRatio(true)
                .setAllowFlipping(false)
                .setAspectRatio(300, 200)
                .start(this);
    }

    @Override
    public void onProgressUpdate(int percentage) {
        Log.d(TAG, "onProgressUpdate: "+percentage);
    }

    @Override
    public void onError() {
        Log.d(TAG, "onError: called");
    }

    @Override
    public void onFinish() {
        Log.d(TAG, "onFinish: called");
    }
}