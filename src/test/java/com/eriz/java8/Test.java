package com.eriz.java8;

public class Test {

    public static void main(String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
    public static int getValue() {
        int i = 1;
        try {
            i = 4;
        } finally{
            i++;
            return i;
        }
    }
}

class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super(id);
        empID = id;
    }
}
