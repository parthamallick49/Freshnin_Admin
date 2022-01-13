package com.freshnin.adminapplication.network;

import com.freshnin.adminapplication.model.ModelOngoingPreOrder;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.model.ModelUploadResponse;

import java.util.List;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    //preorder
    @POST("getAllPreOrderSessions.php")
    Observable<List<ModelPreOrder>> getAllPreOrderSessions();

    @POST("updatePreOrderSessionStatus.php")
    Observable<ModelResponse> updatePreOrderSessionStatus(@Body ModelPreOrder order);

    @POST("newPreOrderItem.php")
    Observable<ModelResponse> createNewPreOrderItem(@Body ModelPreOrder order);

    @Multipart
    @POST("uploadPreOrderItemImage.php")
    Observable<ModelUploadResponse> uploadPreOrderItemImage(@Part("sender_information") RequestBody description, @Part MultipartBody.Part file);


    @POST("getAllItem.php")
    Observable<List<ModelRegularItem>> getAllItem();

    @POST("addNewItem.php")
    Observable<ModelResponse> addNewItem(@Body ModelRegularItem regularItem);

    @POST("deleteRegularItem.php")
    Observable<ModelResponse> deleteRegularItemById(@Body ModelRegularItem regularItem);

    @Multipart
    @POST("uploadItemImage.php")
    Observable<ModelUploadResponse> uploadItemImage(@Part("sender_information") RequestBody description, @Part MultipartBody.Part file);


    //pre-order
    @POST("getAllPreOrders.php")
    Observable<List<ModelOngoingPreOrder>> getAllPreOrders();


    @POST("updatePreOrderStatus.php")
    Observable<ModelResponse> updatePreOrderStatus(@Body ModelOngoingPreOrder order);
}
