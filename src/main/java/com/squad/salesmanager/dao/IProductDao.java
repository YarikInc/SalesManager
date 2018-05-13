package com.squad.salesmanager.dao;

import com.squad.salesmanager.domain.Product;
import com.squad.salesmanager.domain.ProductCategory;

import java.io.IOException;
import java.util.List;

public interface IProductDao {

    List<Product> get() throws IOException;

    List<Product> getByCategory(ProductCategory category) throws IOException;

    void add(Product newProduct);

    void update(Product product);

    void delete(Product product);
}
