package com.freshnin.adminapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelRegularItem implements Parcelable {

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productDes")
    @Expose
    private String productDes;
    @SerializedName("productPicUrl")
    @Expose
    private String productPicUrl;
    @SerializedName("productUnitPrice")
    @Expose
    private int productUnitPrice;
    @SerializedName("productUnitWeight")
    @Expose
    private int productUnitWeight;
    @SerializedName("inStock")
    @Expose
    private int inStock;
    @SerializedName("productCategory")
    @Expose
    private String productCategory;

    public ModelRegularItem(String productId, String productName, String productDes, String productPicUrl,
                            int productUnitPrice, int productUnitWeight, int inStock, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.inStock = inStock;
        this.productCategory = productCategory;
    }


    public ModelRegularItem() {
    }

    public ModelRegularItem(String productCategory) {
        this.productCategory = productCategory;
    }

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

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
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

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public static Creator<ModelRegularItem> getCREATOR() {
        return CREATOR;
    }

    protected ModelRegularItem(Parcel in) {
        productId = in.readString();
        productName = in.readString();
        productDes = in.readString();
        productPicUrl = in.readString();
        productUnitPrice = in.readInt();
        productUnitWeight = in.readInt();
        inStock = in.readInt();
        productCategory = in.readString();
    }

    public static final Creator<ModelRegularItem> CREATOR = new Creator<ModelRegularItem>() {
        @Override
        public ModelRegularItem createFromParcel(Parcel in) {
            return new ModelRegularItem(in);
        }

        @Override
        public ModelRegularItem[] newArray(int size) {
            return new ModelRegularItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(productName);
        dest.writeString(productDes);
        dest.writeString(productPicUrl);
        dest.writeInt(productUnitPrice);
        dest.writeInt(productUnitWeight);
        dest.writeInt(inStock);
        dest.writeString(productCategory);
    }
}
