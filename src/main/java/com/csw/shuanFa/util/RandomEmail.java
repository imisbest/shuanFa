package com.csw.shuanFa.util;

import java.util.HashSet;
import java.util.Set;

public class RandomEmail {
    public static void main(String[] args) {
        Set set = new HashSet();
        int n = 1;
        while (n <= 1000) {
            String stringBuilder = "";
            stringBuilder += (int) (Math.random() * 8) + 1;
            for (int i = 0; i < 9; i++) {
                int a = (int) (Math.random() * 10);
                //System.out.println(a);
                stringBuilder += a;
            }
            stringBuilder += "@qq.com";
            set.add(stringBuilder);
            n++;
            //System.out.println(stringBuilder);
        }
        int ss = 0;
        for (Object o : set) {
            ss++;
            System.out.println(ss + "," + o);
        }
    }
}
