package com.squad.salesmanager.dao;

import com.squad.salesmanager.domain.Product;

import java.io.IOException;
import java.util.List;

public interface IProductDao {

    List<Product> get() throws IOException;

    void add(Product newProduct);

    void update(Product product);

    void delete(Product product);
}
