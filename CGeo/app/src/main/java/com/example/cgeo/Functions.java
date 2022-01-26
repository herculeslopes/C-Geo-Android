package com.example.cgeo;

public class Functions {
    public static double textToDouble(CharSequence cs) {
        String strNum = cs.toString();
        if (strNum.length() > 0) {
            try {
                return Double.parseDouble(strNum);
            } catch (Exception e) {
                return -1;
            }
        } else return 0;
    }
}
