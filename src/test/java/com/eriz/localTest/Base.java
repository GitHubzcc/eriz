package com.eriz.localTest;

import java.util.*;

/**
 * 1248
 * 2
 * 1、事务的传播行为
 * 2、切面通知，beforter、after、around等
 * 3、剑指offter
 * 4、lindlist
 * 5、值传递
 */

public class Base {
    static int i;
    private String name = "name";



    private int age;

    public Base(String name) {
        this.name = name;

    }

    public final int hashCode() {
        return name.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Base) {
            Base anotherString = (Base) obj;
            if (anotherString.name.length() == this.name.length())
                return true;
        }
        return false;
    }

    public static void main(String[] str) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("q");
        linkedList.add("w");
        linkedList.add("e");
        linkedList.add("r");

        System.out.println("========listIterator迭代器=======");
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.add("tt");
            System.out.println(listIterator.next());
        }
        System.out.println("========descending迭代器=======");
        Iterator<String> iterator1 = linkedList.descendingIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        String a="Hello";
        String b=a.substring(0,2);
        System.out.println(b);

//        int s1 = 1;
//        int s2 = 1;
//        int count = 10;
//        int stemp;
//
//        for (int i = 1; i <= count; i++) {
//            if (i == 1) {
//                System.out.println("第1个月兔子数量：" + s1);
//                continue;
//            } else if (i == 2) {
//                System.out.println("第2个月兔子数量" + s1);
//                continue;
//            } else {
//                stemp = s1;
//                s1 = s1 + s2;
//                s2 = stemp;
//                System.out.println("第" + i + "个月兔子数量" + s1);
//            }
//
//        }

//        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入月份");
//        int n = sc.nextInt();
//        System.out.println("在" + n + "月份有" + fun(n) + "对兔子");
    }

    private static int fun(int n) {
        if (n == 1 || n == 2)     //  表示第1月，第2月的对数
            return 1;
        else
            return fun(n - 1) + fun(n - 2);  // 3月之后该怎么算
    }

}
