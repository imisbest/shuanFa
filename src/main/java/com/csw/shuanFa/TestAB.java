package com.csw.shuanFa;

public class TestAB {
    public static void main(String[] args) {
        A a = new B();
        //a.m2();
    }
}
   class A{
       void m1() {
           System.out.println("in m1 a");
       }
   }

class B extends A{
    void m1() {
        System.out.println("in m1 b");
    }

    void m2() {
        System.out.println("in m2 b");
    }
}

