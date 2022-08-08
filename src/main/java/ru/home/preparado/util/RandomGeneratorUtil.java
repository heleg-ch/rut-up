package ru.home.preparado.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGeneratorUtil {

    private static final int CODE_SIZE = 6;

    public static String getCode() {
        return RandomStringUtils.randomAlphanumeric(CODE_SIZE).toUpperCase();
    }

}
