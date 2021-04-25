package com.csw.shuanFa.ThreadXiangMu;

import java.util.ArrayList;
import java.util.List;

public class CutThread {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        int threadNum = 2;  //线程执行数量
        for (int i = 0; i <= data.size() / threadNum; i++) {
            List<String> sublist = data.subList(i * threadNum, i * threadNum + threadNum > data.size() ? data.size() : i * threadNum + threadNum);
            new Thread(() -> {
                System.out.println(sublist + " 线程ID：" + Thread.currentThread().getId());
            }).start();
        }
    }
}
