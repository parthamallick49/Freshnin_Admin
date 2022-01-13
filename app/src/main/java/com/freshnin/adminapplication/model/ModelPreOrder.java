package com.freshnin.adminapplication.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPreOrder implements Parcelable {

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productShortDes")
    @Expose
    private String productShortDes;
    @SerializedName("productPicUrl")
    @Expose
    private String productPicUrl;
    @SerializedName("productUnitPrice")
    @Expose
    private int productUnitPrice;
    @SerializedName("productUnitWeight")
    @Expose
    private int productUnitWeight;
    @SerializedName("sessionStartDate")
    @Expose
    private String sessionStartDate;

    @SerializedName("sessionEndDate")
    @Expose
    private String sessionEndDate;

    @SerializedName("sessionStatus")
    @Expose
    private int sessionStatus;


    @SerializedName("response")
    @Expose
    private Integer response;
    @SerializedName("status")
    @Expose
    private String status;

    public ModelPreOrder(String productId, String productName, String productShortDes, String productPicUrl,
                         int productUnitPrice, int productUnitWeight, String sessionStartDate,
                         String sessionEndDate, Integer response, String status) {
        this.productId = productId;
        this.productName = productName;
        this.productShortDes = productShortDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.sessionStartDate = sessionStartDate;
        this.sessionEndDate = sessionEndDate;
        this.response = response;
        this.status = status;
    }

    public ModelPreOrder(String productId, String productName, String productShortDes, String productPicUrl,
                         int productUnitPrice, int productUnitWeight, String sessionStartDate, String sessionEndDate, int sessionStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productShortDes = productShortDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.sessionStartDate = sessionStartDate;
        this.sessionEndDate = sessionEndDate;
        this.sessionStatus = sessionStatus;
    }

    public ModelPreOrder(String productId, int sessionStatus) {
        this.productId = productId;
        this.sessionStatus = sessionStatus;
    }

    protected ModelPreOrder(Parcel in) {
        productId = in.readString();
        productName = in.readString();
        productShortDes = in.readString();
        productPicUrl = in.readString();
        productUnitPrice = in.readInt();
        productUnitWeight = in.readInt();
        sessionStartDate = in.readString();
        sessionEndDate = in.readString();
        sessionStatus = in.readInt();
        if (in.readByte() == 0) {
            response = null;
        } else {
            response = in.readInt();
        }
        status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(productName);
        dest.writeString(productShortDes);
        dest.writeString(productPicUrl);
        dest.writeInt(productUnitPrice);
        dest.writeInt(productUnitWeight);
        dest.writeString(sessionStartDate);
        dest.writeString(sessionEndDate);
        dest.writeInt(sessionStatus);
        if (response == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(response);
        }
        dest.writeString(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelPreOrder> CREATOR = new Creator<ModelPreOrder>() {
        @Override
        public ModelPreOrder createFromParcel(Parcel in) {
            return new ModelPreOrder(in);
        }

        @Override
        public ModelPreOrder[] newArray(int size) {
            return new ModelPreOrder[size];
        }
    };

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductShortDes() {
        return productShortDes;
    }

    public void setProductShortDes(String productShortDes) {
        this.productShortDes = productShortDes;
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public int getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(int productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public int getProductUnitWeight() {
        return productUnitWeight;
    }

    public void setProductUnitWeight(int productUnitWeight) {
        this.productUnitWeight = productUnitWeight;
    }

    public String getSessionStartDate() {
        return sessionStartDate;
    }

    public void setSessionStartDate(String sessionStartDate) {
        this.sessionStartDate = sessionStartDate;
    }

    public String getSessionEndDate() {
        return sessionEndDate;
    }

    public void setSessionEndDate(String sessionEndDate) {
        this.sessionEndDate = sessionEndDate;
    }

    public int getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(int sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Creator<ModelPreOrder> getCREATOR() {
        return CREATOR;
    }
}
