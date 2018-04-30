package com.squad.salesmanager.domain;

public class Product {

    ProductCategory productCategory;
    String nameProduct;
    double productPacking;
    double price;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getProductPacking() {
        return productPacking;
    }

    public void setProductPacking(double productPacking) {
        this.productPacking = productPacking;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(ProductCategory productCategory, String nameProduct, double productPacking, double price) {
        this.productCategory = productCategory;
        this.nameProduct = nameProduct;
        this.productPacking = productPacking;
        this.price = price;
    }
}
