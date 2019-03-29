package com.eriz.localTest;

import java.util.Iterator;
import java.util.LinkedList;

public class LocalArrayList extends Thread {

    @Override
    public void run() {
        System.out.println("wo shi xiancheng");
    }

    private final int string = 1;

    private final String string2 = "str";

    private static String string3 = "234";

    static {
        System.out.println("父类静态代码块初始化。。。。。");
    }

    static class Static {

    }

    class static2{

    }

    public void get(){
        System.out.println(this.string);
    }

    public static String str = "66";


    public static void main(String[] srgs) {
        LocalArrayList localArrayList = new LocalArrayList();
        localArrayList.run();
    }
}




