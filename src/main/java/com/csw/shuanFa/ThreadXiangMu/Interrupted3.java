package com.csw.shuanFa.ThreadXiangMu;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * 打断 park 线程, 不会清空打断状态
 */
public class Interrupted3 {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("park...");
            LockSupport.park();
            System.out.println("unpark...");
            System.out.println("打断状态：{}" + Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        sleep((long) 0.5);
        t1.interrupt();
    }
}
