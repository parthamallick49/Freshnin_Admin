package com.freshnin.adminapplication.model;

import java.util.List;

public class ModelOnGoingOrder {
    private String orderId;
    private String userId;
    private String itemIds;
    private String totalBill;
    private String deliveryCharge;
    private String deliveryAddress;
    private String inTownDelivery;
    private String orderPlaceDate;
    private String orderPlaceTime;
    private String contactNumber;
    private String paymetType;
    private String orderStatus;
    private List<ModelRegularItem> items;

    public ModelOnGoingOrder(String orderId, String userId, String itemIds, String totalBill, String deliveryCharge, String deliveryAddress, String inTownDelivery, String orderPlaceDate,
                             String orderPlaceTime, String contactNumber, String paymetType, String orderStatus, List<ModelRegularItem> items) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemIds = itemIds;
        this.totalBill = totalBill;
        this.deliveryCharge = deliveryCharge;
        this.deliveryAddress = deliveryAddress;
        this.inTownDelivery = inTownDelivery;
        this.orderPlaceDate = orderPlaceDate;
        this.orderPlaceTime = orderPlaceTime;
        this.contactNumber = contactNumber;
        this.paymetType = paymetType;
        this.orderStatus = orderStatus;
        this.items = items;
    }

    public ModelOnGoingOrder() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemIds() {
        return itemIds;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
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

    public String getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(String orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
    }

    public String getOrderPlaceTime() {
        return orderPlaceTime;
    }

    public void setOrderPlaceTime(String orderPlaceTime) {
        this.orderPlaceTime = orderPlaceTime;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPaymetType() {
        return paymetType;
    }

    public void setPaymetType(String paymetType) {
        this.paymetType = paymetType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ModelRegularItem> getItems() {
        return items;
    }

    public void setItems(List<ModelRegularItem> items) {
        this.items = items;
    }
}
