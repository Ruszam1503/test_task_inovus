package com.example.test_task_inovus.util;

import java.util.Base64;



public class Decoder {
    public static String getBase64Image(byte[] image) {
        return  Base64.getEncoder().encodeToString(image);
    }
}
