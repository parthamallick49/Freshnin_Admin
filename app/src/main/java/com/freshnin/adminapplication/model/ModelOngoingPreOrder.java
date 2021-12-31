package com.freshnin.adminapplication.model;

public class ModelOngoingPreOrder {

    private String orderId;
    private String itemId;
    private String userId;
    private String itemName;
    private String orderPlaceDate;
    private String orderDeliveryDate;
    private String orderQuantity;
    private String deliveryAddress;
    private String inTownDelivery;
    private String deliveryCharge;
    private String totalBill;
    private String advancePyamentAmount;
    private String advancePaymentStatus;
    private String transactionId;
    private String paymnetMethod;
    private String advancePaymentMethod;
    private String orderStatus;
    private String url;

    public ModelOngoingPreOrder(String orderId, String itemId, String userId, String itemName, String orderPlaceDate,
                                String orderDeliveryDate, String orderQuantity, String deliveryAddress,
                                String inTownDelivery, String deliveryCharge, String totalBill,
                                String advancePyamentAmount, String advancePaymentStatus, String transactionId,
                                String paymnetMethod, String advancePaymentMethod, String orderStatus, String url) {
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
}
