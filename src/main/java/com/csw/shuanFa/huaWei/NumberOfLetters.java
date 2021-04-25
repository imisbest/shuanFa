package com.csw.shuanFa.huaWei;

import java.util.Scanner;

/**
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 */
public class NumberOfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        String inputLetter = sc.next();
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputLetter.equalsIgnoreCase(String.valueOf(inputString.charAt(i)))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
