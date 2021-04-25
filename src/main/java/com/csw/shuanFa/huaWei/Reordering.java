package com.csw.shuanFa.huaWei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 注意：输入可能有多组数据(用于不同的调查)。每组数据都包括多行，第一行先输入随机整数的个数N，接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
 * <p>
 * 输出描述:
 * 返回多行，处理后的结果
 */
public class Reordering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        while (sc.hasNext()) {
            int input = sc.nextInt();
            set.add(input);
        }
        Object[] aa = set.toArray();
        Arrays.sort(aa);
        for (Object o : aa) {
            System.out.println(o);
        }
    }
}
