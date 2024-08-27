package com.example;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public class KeyValue {
    private String key;
    private String value;

    @Creator
    public static KeyValue of(String key, String value) {
        final KeyValue keyValue = new KeyValue();
        keyValue.key = key;
        keyValue.value = value;
        return keyValue;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
