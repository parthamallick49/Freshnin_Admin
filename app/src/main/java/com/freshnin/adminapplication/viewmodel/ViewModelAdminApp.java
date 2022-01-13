package com.freshnin.adminapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.adminapplication.model.ModelOngoingPreOrder;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.model.ModelUploaInfo;
import com.freshnin.adminapplication.model.ModelUploadResponse;
import com.freshnin.adminapplication.repository.RepositoryAdminApp;
import com.freshnin.adminapplication.tools.ProgressRequestBody;

import java.io.File;
import java.util.List;

public class ViewModelAdminApp extends AndroidViewModel {
    RepositoryAdminApp repositoryAdminApp;

    public ViewModelAdminApp(@NonNull Application application) {
        super(application);
        repositoryAdminApp=new RepositoryAdminApp();
    }


    public LiveData<List<ModelPreOrder>> getAllPreOrderSessions(){
        return repositoryAdminApp.getAllPreOrderSessions();
    }
    public LiveData<ModelResponse>  createNewPreOrderItem(ModelPreOrder order){
        return repositoryAdminApp.createNewPreOrderItem(order);
    }

    public LiveData<ModelUploadResponse> uploadPreOrderItemImage(File file , ModelUploaInfo modelUploaInfo, ProgressRequestBody progressRequestBody){
        return repositoryAdminApp.uploadPreOrderItemImage(file,modelUploaInfo,progressRequestBody);
    }

    public LiveData<ModelResponse> updatePreOrderSessionStatus(ModelPreOrder order){
        return repositoryAdminApp.updatePreOrderSessionStatus(order);
    }


    public LiveData<List<ModelRegularItem>> getAllItem(){
        return repositoryAdminApp.getAllItem();
    }

    public LiveData<ModelResponse> deleteRegularItemById(ModelRegularItem regularItem){
        return repositoryAdminApp.deleteRegularItemById(regularItem);
    }

    public LiveData<ModelUploadResponse> uploadItemImage(File file , ModelUploaInfo modelUploaInfo, ProgressRequestBody progressRequestBody){
        return  repositoryAdminApp.uploadItemImage(file,modelUploaInfo,progressRequestBody);
    }

    public LiveData<ModelResponse> addNewItem( ModelRegularItem regularItem){
        return repositoryAdminApp.addNewItem(regularItem);
    }

    public LiveData<List<ModelOngoingPreOrder>>  getAllPreOrders(){
        return repositoryAdminApp.getAllPreOrders();
    }

    public LiveData<ModelResponse>  updatePreOrderStatus(ModelOngoingPreOrder order){
        return repositoryAdminApp.updatePreOrderStatus(order);
    }

}
