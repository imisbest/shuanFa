package com.csw.algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * @author imisbest
 */
public class FastJump {
    public static void main(String[] args) {
        int[] su = {4, 1, 2, 6, 4, 9, 2, 6, 3, 5, 2, 4, 1, 6, 8, 3, 9};
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < su.length; i++) {
            //从左往右第一个开始跳
            int buJin = 0;
            int startNum = su[index];
            int max = 0;
            for (int j = 0; j <= startNum; j++) {
                //最后一次比较要在范围内
                if ((i + j) < su.length) {
                    //模拟最终结果
                    int resultInt = su[i + j] - startNum + j;
                    if (resultInt >= max) {
                        max = su[i + j];
                        index = i + j;
                        buJin = j;
                    }
                }
            }
            i = i + buJin;
            list.add(max);
        }
        System.out.println(list);
    }

}
