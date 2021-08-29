package com.csw.algorithm.huawei_jikao;

import java.util.Scanner;

/**
 * 奶牛均分
 */
public class Miu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        int sum = 0;
        int allCounts = 0, counts;
        boolean flg = false;
        int[] ins = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            int num1 = sc.nextInt();
            ins[i] = num1;
            sum += num1;
        }
        if (sum % numCount > 0) {
            System.out.println("-1");
        } else {
            int avg = sum / numCount;
            for (int i = 0; i < numCount; i++) {
                if (Math.abs(avg - ins[i]) % 2 != 0) {
                    System.out.println("-1");
                    System.out.println("进来了mei");
                    flg = true;
                    break;
                }
            }
            System.out.println("进来了" + flg);
            if (flg == false) {
                System.out.println("进来了");
                for (int i = 0; i < numCount; i++) {
                    allCounts += Math.abs(avg - ins[i]) / 2;
                }
                counts = allCounts / 2;
                System.out.println(counts);
            }

        }
    }
}
