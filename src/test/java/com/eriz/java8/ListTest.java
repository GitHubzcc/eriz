package com.eriz.java8;

import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("qw", "rt", "yu", "gfs");
        list.forEach(k-> System.out.println(k+1));
    }
}
