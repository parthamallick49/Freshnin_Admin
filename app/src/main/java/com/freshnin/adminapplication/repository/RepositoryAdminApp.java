package com.freshnin.adminapplication.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.adminapplication.model.ModelOngoingPreOrder;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.model.ModelUploaInfo;
import com.freshnin.adminapplication.model.ModelUploadResponse;
import com.freshnin.adminapplication.network.ApiClient;
import com.freshnin.adminapplication.network.ApiInterface;
import com.freshnin.adminapplication.tools.ProgressRequestBody;
import com.google.gson.Gson;

import java.io.File;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;


@SuppressLint("CheckResult")
public class RepositoryAdminApp {

    private static final String TAG = "RepositoryUser";
    private ApiInterface apiInterface;

    public RepositoryAdminApp() {
        apiInterface = ApiClient.getApiInterface();
    }



    public LiveData<List<ModelPreOrder>> getAllPreOrderSessions(){
        MutableLiveData<List<ModelPreOrder>> result=new MutableLiveData<>();

        apiInterface.getAllPreOrderSessions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelPreOrder>>() {
                    @Override
                    public void accept(List<ModelPreOrder> modelPreOrders) throws Exception {
                        result.postValue(modelPreOrders);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "getAllPreOrderSessions: error:"+throwable.getMessage());
                    }
                });
        return result;
    }

    public LiveData<ModelResponse>  createNewPreOrderItem( ModelPreOrder order){
        MutableLiveData<ModelResponse> result=new MutableLiveData<>();
        apiInterface.createNewPreOrderItem(order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse modelResponse) throws Exception {
                        result.postValue(modelResponse);
                        Log.d(TAG, "accept: "+modelResponse.getStatus());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "createNewPreOrderItem: error:"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }

    public LiveData<ModelResponse> updatePreOrderSessionStatus(ModelPreOrder order){
        MutableLiveData<ModelResponse> result=new MutableLiveData<>();
        apiInterface.updatePreOrderSessionStatus(order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse modelResponse) throws Exception {
                        result.postValue(modelResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "updatePreOrderSessionStatus: errror:"+throwable.getMessage());
                    }
                });
        return result;
    }

    public LiveData<ModelUploadResponse> uploadPreOrderItemImage(File file , ModelUploaInfo modelUploaInfo, ProgressRequestBody progressRequestBody){
        final MutableLiveData<ModelUploadResponse> response=new MutableLiveData<>();

        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(),progressRequestBody);

        Gson gson = new Gson();
        String patientData = gson.toJson(modelUploaInfo);

        RequestBody description = RequestBody.create(okhttp3.MultipartBody.FORM, patientData);

        Log.d(TAG, "imageUpload: repo called");
        apiInterface.uploadPreOrderItemImage(description,body).subscribeOn(Schedulers.io())
                //.timeout(120000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelUploadResponse>() {
                    @Override
                    public void accept(ModelUploadResponse modelUploadResponse) throws Exception {
                        response.postValue(modelUploadResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "imageUpload: error:"+throwable.getMessage());
                        response.postValue(null);
                    }
                });
        return response;
    }


    public LiveData<List<ModelRegularItem>> getAllItem(){
        MutableLiveData<List<ModelRegularItem>> result=new MutableLiveData<>();

        apiInterface.getAllItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelRegularItem>>() {
                    @Override
                    public void accept(List<ModelRegularItem> modelRegularItems) throws Exception {
                        result.postValue(modelRegularItems);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "getAllItem: error"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }

    public LiveData<ModelResponse> deleteRegularItemById(ModelRegularItem regularItem){
        MutableLiveData<ModelResponse> result=new MutableLiveData<>();
        apiInterface.deleteRegularItemById(regularItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse modelResponse) throws Exception {
                        result.postValue(modelResponse);
                        Log.d(TAG, "deleteRegularItemById: status="+modelResponse.getStatus());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "deleteRegularItemById: error:"+throwable.getMessage());
                    }
                });
        return result;
    }

    public LiveData<ModelUploadResponse> uploadItemImage(File file , ModelUploaInfo modelUploaInfo, ProgressRequestBody progressRequestBody){
        final MutableLiveData<ModelUploadResponse> response=new MutableLiveData<>();

        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(),progressRequestBody);

        Gson gson = new Gson();
        String patientData = gson.toJson(modelUploaInfo);

        RequestBody description = RequestBody.create(okhttp3.MultipartBody.FORM, patientData);

        Log.d(TAG, "imageUpload: repo called");
        apiInterface.uploadItemImage(description,body).subscribeOn(Schedulers.io())
                //.timeout(120000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelUploadResponse>() {
                    @Override
                    public void accept(ModelUploadResponse modelUploadResponse) throws Exception {
                        response.postValue(modelUploadResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "imageUpload: error:"+throwable.getMessage());
                        response.postValue(null);
                    }
                });
        return response;
    }

    public LiveData<ModelResponse> addNewItem( ModelRegularItem regularItem){
        MutableLiveData<ModelResponse> result=new MutableLiveData<>();
        apiInterface.addNewItem(regularItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse modelResponse) throws Exception {
                        result.postValue(modelResponse);
                        Log.d(TAG, "addNewItem: status:"+modelResponse.getStatus());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "addNewItem: error:"+throwable.getMessage());
                    }
                });

        return result;
    }

    public LiveData<List<ModelOngoingPreOrder>>  getAllPreOrders(){
        MutableLiveData<List<ModelOngoingPreOrder>> result=new MutableLiveData<>();
        apiInterface.getAllPreOrders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelOngoingPreOrder>>() {
                    @Override
                    public void accept(List<ModelOngoingPreOrder> modelOngoingPreOrders) throws Exception {
                        result.postValue(modelOngoingPreOrders);
                    }
                },new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "getAllPreOrders error: "+throwable.getMessage());
                    }
                });

        return result;
    }

    public LiveData<ModelResponse>  updatePreOrderStatus(ModelOngoingPreOrder order){
        MutableLiveData<ModelResponse> result=new MutableLiveData<>();
        apiInterface.updatePreOrderStatus(order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse modelResponse) throws Exception {
                        result.postValue(modelResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "updatePreOrderStatus error: "+throwable.getMessage());
                    }
                });

        return result;
    }

}
