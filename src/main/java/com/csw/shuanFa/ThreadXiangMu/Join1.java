package com.csw.shuanFa.ThreadXiangMu;

import static java.lang.Thread.sleep;

/**
 * 因为主线程和线程 t1 是并行执行的，t1 线程需要 1 秒之后才能算出  r=10
 * 而主线程一开始就要打印 r 的结果，所以只能打印出  r=0
 */
public class Join1 {
    static int r = 0;

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {
        System.out.println("开始main");
        Thread t1 = new Thread(() -> {
            System.out.println("开始thread");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束thread");
            r = 10;
        });
        t1.start();
        //t1.join();
        System.out.println("结果main为:{}" + r);
        System.out.println("结束main");
    }
}
