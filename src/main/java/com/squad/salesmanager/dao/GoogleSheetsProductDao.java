package com.squad.salesmanager.dao;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.squad.salesmanager.domain.Product;
import com.squad.salesmanager.google.sheets.SheetsServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * This dao users Google Sheets api as a Storage
 */

@Slf4j
public class GoogleSheetsProductDao /*implements IProductDao*/ {
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

    @Test
    public /*List<Product>*/ void get() throws IOException {
        List<String> ranges = Arrays.asList("A1:E18");
        BatchGetValuesResponse readResult = sheetsService.spreadsheets().values().batchGet(SPREADSHEET_ID).setRanges(ranges).execute();

        // TODO: 
        List<List<Object>> values = readResult.getValueRanges().get(0).getValues();
        log.info("{}", values);
    }

    public void add(Product newProduct) {

    }

    public void update(Product product) {

    }

    public void delete(Product product) {

    }
}
