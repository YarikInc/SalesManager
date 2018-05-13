package com.squad.salesmanager.dao;

import com.squad.salesmanager.domain.Product;
import com.squad.salesmanager.domain.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
@Slf4j
public class GoogleSheetsProductDaoTest {

    @Test
    public void testGet() {
        List<Product> products = new GoogleSheetsProductDao().get();
        log.info("{}", products);
        // TODO: add asserts
    }

    @Test
    public void testGetByCategory() {
        List<Product> products = new GoogleSheetsProductDao().getByCategory(ProductCategory.PACKED_SWEETS);
        log.info("{}", products);
        // TODO: add asserts
    }
}
