package ru.mustaevtt.mimimetr.util;

import java.util.Base64;

public class Util {
    public static String decodeBytesToStringBase64(byte[] array) {
        return new String(Base64.getEncoder().encode(array));
    }
}
