package com.freshnin.adminapplication.model;

public class ModelRegularItem {

    private int id;
    private String productId;
    private String productName;
    private String productDes;
    private String productPicUrl;
    private String productUnitPrice;
    private String productUnitWeight;
    private String inStock;
    private String productCategory;
    private boolean isFavourite;

    public ModelRegularItem(int id, String productId, String productName, String productDes,
                            String productPicUrl, String productUnitPrice, String productUnitWeight, String inStock, String productCategory) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.inStock = inStock;
        this.productCategory = productCategory;
    }

    public ModelRegularItem(String productName) {
        this.productName = productName;
    }

    public ModelRegularItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
