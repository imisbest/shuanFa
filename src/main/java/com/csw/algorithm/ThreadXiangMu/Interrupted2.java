package com.csw.algorithm.ThreadXiangMu;

import static java.lang.Thread.sleep;

/**
 * 打断正常运行的线程, 不会清空打断状态
 */
public class Interrupted2 {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();

                if (interrupted) {
                    System.out.println(" 打断状态: {}" + interrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        sleep((long) 0.5);
        t2.interrupt();
    }
}
