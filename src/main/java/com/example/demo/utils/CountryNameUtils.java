package com.example.demo.utils;

public class CountryNameUtils {

    public static String countryCode(String address) {
        String[] addressArray = address.split(",");
        int len = addressArray.length;
        return addressArray[len - 1];
    }
}
