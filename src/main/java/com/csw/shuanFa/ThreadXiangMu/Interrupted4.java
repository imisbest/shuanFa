package com.csw.shuanFa.ThreadXiangMu;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * 如果打断标记已经是 true, 则 park 会失效
 */
public class Interrupted4 {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    private static void test4() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("park...");
                LockSupport.park();
                System.out.println("打断状态：{}" + Thread.currentThread().isInterrupted());
            }
        });
        t1.start();
        sleep(1);
        t1.interrupt();
    }
}
