package com.squad.salesmanager.utils;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter implements  Converter{

    private ArrayList<String> nameProduct;
    private ArrayList<Double> productPacking;
    private ArrayList<Integer> piecesInABox;
    private ArrayList<Double> priceByKg;
    private ArrayList<Double> totalPrice;


    public ArrayList<String> getNameProduct() {
        return nameProduct;
    }

    public ArrayList<Double> getProductPacking() {
        return productPacking;
    }

    public ArrayList<Integer> getPiecesInABox() {
        return piecesInABox;
    }

    public ArrayList<Double> getPriceByKg() {
        return priceByKg;
    }

    public ArrayList<Double> getTotalPrice() {
        return totalPrice;
    }

    @Override
    public Object convert(Object o) {


        List<List<List>> products = new ArrayList<>();
        List<List> product = new ArrayList();

        products.add((List) o);
        for (int i = 0 ; i < products.get(0).size() ; i ++)
            product.add(products.get(0).get(i));

        ArrayList items = new ArrayList();
        for (int i = 0 ; i< product.size() ; i ++)
            for(int j = 0 ; j< product.get(i).size() ; j ++)
                items.add(product.get(i).get(j));


        try {
            for (int i = 0 ;  i< product.size() ; i ++){
                for(int j = 0 ; j< product.get(i).size() ; j ++){
                    nameProduct.set(j, (String) product.get(i).get(j));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }



}


