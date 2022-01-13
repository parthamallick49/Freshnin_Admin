package com.freshnin.adminapplication.activity;

import static com.theartofdev.edmodo.cropper.CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.callbacks.ImageUploadCallbacks;
import com.freshnin.adminapplication.databinding.ActivityAddRegularItemBinding;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.model.ModelUploaInfo;
import com.freshnin.adminapplication.model.ModelUploadResponse;
import com.freshnin.adminapplication.tools.ProgressRequestBody;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;

public class ActivityAddRegularItem extends AppCompatActivity  implements ImageUploadCallbacks {
    public static final int EXTERNAL_STORAGE_CODE = 222;
    private static final int PIC_PHOTO = 123;
    private static final String TAG = "ActivityAddRegularItem";
    private ActivityAddRegularItemBinding binding;

    Uri pickedPhotoUri;
    File filePhoto;
    boolean isImageSelected = false;
    String coverImageLink="";
    Dialog dialogLoading;
    ViewModelAdminApp viewModelAdminApp;

    ArrayAdapter<String> adapterCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddRegularItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.aariToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.aariFoodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requestStoragePermission()) {
                    getImageFromAlbum(PIC_PHOTO);
                }
            }
        });

        binding.aariBtnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(filePhoto!=null){
                    uploadPhoto(filePhoto);
                }
            }
        });

        binding.aariBtnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.aariEtProductName.getText().toString().isEmpty() ||
                        binding.aariEtProductDiscription.getText().toString().isEmpty()||
                        binding.aariEtProductUnitPrice.getText().toString().isEmpty() ||
                        binding.aariSpinnerCategory.getSelectedItem().toString().equals("Select Category")||
                        binding.aariEtProductUnitWeight.getText().toString().isEmpty()||coverImageLink.isEmpty()){
                }else{
                    addNewItem(new ModelRegularItem(
                            Tools.generate9DigitDeliveryID("regularItem"),
                            binding.aariEtProductName.getText().toString(),
                            binding.aariEtProductDiscription.getText().toString(),
                            coverImageLink,
                            Integer.parseInt(binding.aariEtProductUnitPrice.getText().toString()),
                            Integer.parseInt(binding.aariEtProductUnitWeight.getText().toString()),
                            1, //1=inStock 0.out of stock
                            categoryConversion(binding.aariSpinnerCategory.getSelectedItem().toString())

                    ));
                }
            }
        });

    }

    String categoryConversion(String data){
        switch (data){
            case "Dry Food":
                return "dry-food";
            case "Edible Oil":
                return "edible-oil";
            case "Herbal Item":
                return  "harbal";
            default:
                return "others";
        }
    }

    private void init(){
        setSupportActionBar(binding.aariToolbar);
        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.days_list));
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.aariSpinnerCategory.setAdapter(adapterCategory);

        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityAddRegularItem.this);
        binding.aariBtnAddItem.setEnabled(false);
    }

    void addNewItem(ModelRegularItem regularItem){
        /*Log.d(TAG, "addNewItem: "+
                regularItem.getProductId()+"\n"+
                regularItem.getProductName()+"\n"+
                regularItem.getProductDes()+"\n"+
                regularItem.getProductUnitPrice()+"\n"+
                regularItem.getProductUnitPrice()+"\n"+
                regularItem.getProductCategory()+"\n"+
                regularItem.getProductPicUrl()+"\n"+
                regularItem.getInStock()+"\n");*/

        dialogLoading.show();
        viewModelAdminApp.addNewItem(regularItem).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                dialogLoading.dismiss();
                if(modelResponse!=null && modelResponse.getResponse()==1){
                    onBackPressed();
                    Toast.makeText(ActivityAddRegularItem.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ActivityAddRegularItem.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    //upload image related
    private void uploadPhoto(File file) {
        if (file != null) {
            dialogLoading.show();
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, "image", ActivityAddRegularItem.this);
            viewModelAdminApp.uploadItemImage(file, new ModelUploaInfo(Tools.generate9DigitDeliveryID("regularitem")),progressRequestBody)
                    .observe(this, new Observer<ModelUploadResponse>() {
                        @Override
                        public void onChanged(ModelUploadResponse modelUploadResponse) {
                            if(modelUploadResponse==null){
                                dialogLoading.dismiss();
                                Toast.makeText(ActivityAddRegularItem.this, "Photo Upload Failed!!", Toast.LENGTH_SHORT).show();
                            }else if (modelUploadResponse.getMessage().equals("Uploaded successfuly")){
                                dialogLoading.dismiss();
                                coverImageLink=modelUploadResponse.getLink();
                                binding.aariBtnAddItem.setEnabled(true);
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
                Toast.makeText(ActivityAddRegularItem.this, "Permission Denied", Toast.LENGTH_SHORT).show();
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
                binding.aariFoodImage.setImageURI(pickedPhotoUri);
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
                .setAspectRatio(400, 400)
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