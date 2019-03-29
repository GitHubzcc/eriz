package com.eriz.localTest;

import java.util.ArrayList;

public class Base2 {

    public static int lengthOfLongestSubstring(String s) {
        String[] arr = s.split("");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int result = sb.indexOf(arr[i]);

            System.out.println(result);
            //sb.append(arr[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("1qewqweqweq");
    }
}



