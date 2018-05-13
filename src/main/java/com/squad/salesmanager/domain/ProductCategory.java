package com.squad.salesmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProductCategory {
    PACKED_SWEETS("Фасованные конфеты"),
    WEIGHT_CANDY("Весовые конфеты"),
    WEIGHT_COOKIE("Весовое печенье"),
    PIECE_GOODS("Штучка"),
    PACKAGED_SWEETS("Пакетированные конфеты"),
    COFFEE("Кофе");

    @Getter
    private String russianName;

}
