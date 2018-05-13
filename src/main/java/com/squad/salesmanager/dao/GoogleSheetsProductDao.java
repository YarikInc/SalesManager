package com.squad.salesmanager.dao;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.squad.salesmanager.domain.Product;
import com.squad.salesmanager.domain.ProductCategory;
import com.squad.salesmanager.google.sheets.SheetsServiceUtil;
import com.squad.salesmanager.utils.ProductConverter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This dao users Google Sheets api as a Storage
 */

@Slf4j
public class GoogleSheetsProductDao implements IProductDao {
    // FIXME: read from property file
    private static final String SPREADSHEET_ID="19_Ef9M60sn-PInse0ij0yvrh3hc4y7jal-wRK3EqtnE";

    private static Sheets sheetsService;

    public GoogleSheetsProductDao() {
        try {
            sheetsService = SheetsServiceUtil.getSheetsService();
        } catch (IOException e) {

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public List<Product> get() {
        return Arrays.stream(ProductCategory.values())
                .map(this::getByCategory)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Product> getByCategory(ProductCategory category) {
        List<String> ranges = Arrays.asList(String.format("%s!A:ZZ", category.getRussianName()));
        BatchGetValuesResponse readResult = null;
        try {
            readResult = sheetsService.spreadsheets()
                    .values()
                    .batchGet(SPREADSHEET_ID)
                    .setRanges(ranges)
                    .setMajorDimension("Columns")
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ProductConverter(category).convert(readResult.getValueRanges().get(0).getValues());
    }

    public void add(Product newProduct) {
        // TODO: add implementation
    }

    public void update(Product product) {
        // TODO: add implementation
    }

    public void delete(Product product) {
        // TODO: add implementation
    }
}
