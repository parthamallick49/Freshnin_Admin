package com.freshnin.adminapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelOngoingPreOrder implements Parcelable {

    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("itemId")
    @Expose
    private String itemId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("orderPlaceDate")
    @Expose
    private String orderPlaceDate;
    @SerializedName("orderDeliveryDate")
    @Expose
    private String orderDeliveryDate;
    @SerializedName("orderQuantity")
    @Expose
    private String orderQuantity;
    @SerializedName("deliveryAddress")
    @Expose
    private String deliveryAddress;
    @SerializedName("inTownDelivery")
    @Expose
    private String inTownDelivery;
    @SerializedName("deliveryCharge")
    @Expose
    private String deliveryCharge;
    @SerializedName("totalBill")
    @Expose
    private String totalBill;
    @SerializedName("advancePyamentAmount")
    @Expose
    private String advancePyamentAmount;
    @SerializedName("advancePaymentStatus")
    @Expose
    private String advancePaymentStatus;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("paymnetMethod")
    @Expose
    private String paymnetMethod;
    @SerializedName("advancePaymentMethod")
    @Expose
    private String advancePaymentMethod;
    @SerializedName("orderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("url")
    @Expose
    private String url;

    public ModelOngoingPreOrder(String orderId, String itemId, String userId,
                                String itemName, String orderPlaceDate,
                                String orderDeliveryDate, String orderQuantity,
                                String deliveryAddress, String inTownDelivery,
                                String deliveryCharge, String totalBill,
                                String advancePyamentAmount, String advancePaymentStatus,
                                String transactionId, String paymnetMethod,
                                String advancePaymentMethod, String orderStatus,
                                String url) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.userId = userId;
        this.itemName = itemName;
        this.orderPlaceDate = orderPlaceDate;
        this.orderDeliveryDate = orderDeliveryDate;
        this.orderQuantity = orderQuantity;
        this.deliveryAddress = deliveryAddress;
        this.inTownDelivery = inTownDelivery;
        this.deliveryCharge = deliveryCharge;
        this.totalBill = totalBill;
        this.advancePyamentAmount = advancePyamentAmount;
        this.advancePaymentStatus = advancePaymentStatus;
        this.transactionId = transactionId;
        this.paymnetMethod = paymnetMethod;
        this.advancePaymentMethod = advancePaymentMethod;
        this.orderStatus = orderStatus;
        this.url = url;
    }

    public ModelOngoingPreOrder() {
    }




    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(String orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
    }

    public String getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getInTownDelivery() {
        return inTownDelivery;
    }

    public void setInTownDelivery(String inTownDelivery) {
        this.inTownDelivery = inTownDelivery;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    public String getAdvancePyamentAmount() {
        return advancePyamentAmount;
    }

    public void setAdvancePyamentAmount(String advancePyamentAmount) {
        this.advancePyamentAmount = advancePyamentAmount;
    }

    public String getAdvancePaymentStatus() {
        return advancePaymentStatus;
    }

    public void setAdvancePaymentStatus(String advancePaymentStatus) {
        this.advancePaymentStatus = advancePaymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymnetMethod() {
        return paymnetMethod;
    }

    public void setPaymnetMethod(String paymnetMethod) {
        this.paymnetMethod = paymnetMethod;
    }

    public String getAdvancePaymentMethod() {
        return advancePaymentMethod;
    }

    public void setAdvancePaymentMethod(String advancePaymentMethod) {
        this.advancePaymentMethod = advancePaymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




    //================================
    protected ModelOngoingPreOrder(Parcel in) {
        orderId = in.readString();
        itemId = in.readString();
        userId = in.readString();
        itemName = in.readString();
        orderPlaceDate = in.readString();
        orderDeliveryDate = in.readString();
        orderQuantity = in.readString();
        deliveryAddress = in.readString();
        inTownDelivery = in.readString();
        deliveryCharge = in.readString();
        totalBill = in.readString();
        advancePyamentAmount = in.readString();
        advancePaymentStatus = in.readString();
        transactionId = in.readString();
        paymnetMethod = in.readString();
        advancePaymentMethod = in.readString();
        orderStatus = in.readString();
        url = in.readString();
    }

    public static final Creator<ModelOngoingPreOrder> CREATOR = new Creator<ModelOngoingPreOrder>() {
        @Override
        public ModelOngoingPreOrder createFromParcel(Parcel in) {
            return new ModelOngoingPreOrder(in);
        }

        @Override
        public ModelOngoingPreOrder[] newArray(int size) {
            return new ModelOngoingPreOrder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderId);
        dest.writeString(itemId);
        dest.writeString(userId);
        dest.writeString(itemName);
        dest.writeString(orderPlaceDate);
        dest.writeString(orderDeliveryDate);
        dest.writeString(orderQuantity);
        dest.writeString(deliveryAddress);
        dest.writeString(inTownDelivery);
        dest.writeString(deliveryCharge);
        dest.writeString(totalBill);
        dest.writeString(advancePyamentAmount);
        dest.writeString(advancePaymentStatus);
        dest.writeString(transactionId);
        dest.writeString(paymnetMethod);
        dest.writeString(advancePaymentMethod);
        dest.writeString(orderStatus);
        dest.writeString(url);
    }
}
