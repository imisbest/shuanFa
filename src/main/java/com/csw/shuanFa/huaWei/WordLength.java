package com.csw.shuanFa.huaWei;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class WordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        if (inputString.equals("")) {
            System.out.println("输入不正确");
        } else if (inputString.length() > 5000) {
            System.out.println("长度太长");

        } else {
            String[] splitSz = inputString.split(" ");
            System.out.println("最后一个单词长度是" + splitSz[splitSz.length - 1].length());

        }
    }
}
