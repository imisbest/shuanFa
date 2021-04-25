package com.csw.shuanFa.ThreadXiangMu;

import static java.lang.Thread.sleep;

public class Interrupted1 {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        sleep((long) 0.5);
        t1.interrupt();
        System.out.println(" 打断状态: {}" + t1.isInterrupted());
    }
}
