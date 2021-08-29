package com.csw.algorithm;

public class TestMN {
    public static void main(String[] args) {
        int m = 5, n = 4;
        m = m + 1;
        n = n + 1;
        int res = --m + n--;
        System.out.println(res);
    }
}
