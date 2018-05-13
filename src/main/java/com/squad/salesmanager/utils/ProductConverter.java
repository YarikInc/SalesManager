package com.squad.salesmanager.utils;

import com.squad.salesmanager.domain.Product;
import com.squad.salesmanager.domain.ProductCategory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class ProductConverter implements Converter<List<List<Object>>, List<Product>> {
    @NonNull
    private ProductCategory category;

    public Product convertSingle(List<Object> fields) {

        List<String> stringList = fields.stream().map(String::valueOf).collect(Collectors.toList());

        return Product.builder()
                .productCategory(category)
                .nameProduct(stringList.get(0))
                .productPacking(Double.valueOf(stringList.get(1)))
                .piecesInABox(Integer.valueOf(stringList.get(2)))
                .priceByKg(Double.valueOf(stringList.get(3)))
                .totalPrice(Double.valueOf(stringList.get(4)))
                .build();
    }

    @Override
    public List<Product> convert(List<List<Object>> lists) {
        int numberOfItems = lists.get(0).size()-1;

        if(numberOfItems==0) return Collections.EMPTY_LIST;

        return IntStream.range(1, numberOfItems)
                .mapToObj(count -> Product.builder()
                        .productCategory(category)
                        .nameProduct(getProductName(lists, count))
                        .productPacking(getProductPackaging(lists, count))
                        .piecesInABox(getPiecesInABox(lists, count))
                        .priceByKg(getPriceByKg(lists, count))
                        .totalPrice(getTotalPrice(lists, count))
                        .build()
                ).collect(Collectors.toList());
    }

    private String getProductName(List<List<Object>> lists, int itemCount) {
        return String.valueOf(lists.get(0).get(itemCount));
    }

    private Double getProductPackaging(List<List<Object>> lists, int itemCount) {
        String str = String.valueOf(lists.get(1).get(itemCount));
        return str.isEmpty()? Double.valueOf(0)
                : Double.valueOf(str);
    }

    private Integer getPiecesInABox(List<List<Object>> lists, int itemCount) {
        if(!isPiecesInABoxExists(lists)) return Integer.valueOf(0);
        String str = String.valueOf(lists.get(3).get(itemCount));
        return str.isEmpty()? Integer.valueOf(0)
                : Integer.valueOf(str);
    }

    private Double getPriceByKg(List<List<Object>> lists, int itemCount) {
        String str = String.valueOf(lists.get(2).get(itemCount))/*.replace('.', ',')*/;
        return str.isEmpty()? Double.valueOf(0)
                : Double.valueOf(str);
    }

    private Double getTotalPrice(List<List<Object>> lists, int itemCount) {
        if(!isTotalPriceExists(lists)) return Double.valueOf(0);
        String str = String.valueOf(lists.get(4).get(itemCount))/*.replace('.', ',')*/;
        return str.isEmpty()? Double.valueOf(0)
                : Double.valueOf(str);
    }

    private Boolean isPiecesInABoxExists(List<List<Object>> lists) {
        String columnName = String.valueOf(lists.get(3).get(0));
        return columnName.equalsIgnoreCase("шт в ящ.")&&lists.get(3).size()>1;
    }

    private Boolean isTotalPriceExists(List<List<Object>> lists) {
        String columnName = String.valueOf(lists.get(4).get(0));
        return columnName.equalsIgnoreCase("цена")&&lists.get(4).size()>1;
    }

}
