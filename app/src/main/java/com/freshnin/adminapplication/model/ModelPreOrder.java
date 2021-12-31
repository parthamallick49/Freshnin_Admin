package com.freshnin.adminapplication.model;



public class ModelPreOrder {

    private String productId;
    private String productName;
    private String productShortDes;
    private String productPicUrl;
    private String productUnitPrice;
    private String productUnitWeight;
    private String sessionStartDate;
    private String sessionEndDate;
    private Integer response;
    private String status;

    public ModelPreOrder(String productId, String productName, String productShortDes, String productPicUrl,
                         String productUnitPrice, String productUnitWeight, String sessionStartDate,
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

    public ModelPreOrder() {

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

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductUnitWeight() {
        return productUnitWeight;
    }

    public void setProductUnitWeight(String productUnitWeight) {
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
}
