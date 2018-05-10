package com.squad.salesmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

    private ProductCategory productCategory;
    private String nameProduct;
    private double productPacking;
    private int piecesInABox;
    private double priceByKg;
    private double totalPrice;

}
