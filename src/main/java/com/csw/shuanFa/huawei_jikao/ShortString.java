package com.csw.shuanFa.huawei_jikao;

import java.util.Scanner;

/**
 * abcdef  abcdef
 * bcdefa  acdefb
 */
public class ShortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] cha = s.toCharArray();
        for (int i = 0; i < cha.length - 1; i++) {
            for (int j = i; j < cha.length; j++) {
                if (cha[i] > cha[j]) {
                    char temp = cha[j];
                    cha[j] = cha[i];
                    cha[i] = temp;
                }
            }
        }
        char[] oCha = s.toCharArray();
        int index = -1;

        for (int j = 0; j < cha.length; j++) {
            if (oCha[j] > cha[j]) {
                index = j;
                break;
                /*
                 * abced
                 * abcde
                 * */
            }
        }
        // System.out.println(index);
        String res = "";
        if (index != -1) {
            int oIndex = index;
            int nIndex = s.indexOf(cha[index]);
            char ochar = oCha[index];
            char nChar = cha[index];

            for (int i = 0; i < s.length(); i++) {
                if (i == oIndex) {
                    res += nChar;
                } else if (i == nIndex) {
                    res += ochar;
                } else {
                    res += s.charAt(i);
                }
            }
        } else {
            res = s;
        }
        System.out.println(res);
    }
}
