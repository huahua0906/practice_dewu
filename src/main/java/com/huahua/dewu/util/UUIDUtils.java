package com.huahua.dewu.util;

import java.util.UUID;


public class UUIDUtils {
    public static final String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
