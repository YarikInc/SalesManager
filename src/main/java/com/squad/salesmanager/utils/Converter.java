package com.squad.salesmanager.utils;

public interface Converter<FROM,TO> {
    TO convert(FROM from);
}
