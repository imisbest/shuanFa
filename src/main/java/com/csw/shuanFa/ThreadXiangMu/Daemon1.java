package com.csw.shuanFa.ThreadXiangMu;

import static java.lang.Thread.sleep;

/**
 * 默认情况下，Java 进程需要等待所有线程都运行结束，才会结束。有一种特殊的线程叫做守护线程，只要其它非守
 * 护线程运行结束了，即使守护线程的代码没有执行完，也会强制结束。
 */
public class Daemon1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始运行...");
        Thread t1 = new Thread(() -> {
            System.out.println("开始运行...");
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行结束...");
        }, "daemon");
// 设置该线程为守护线程
        t1.setDaemon(true);
        t1.start();
        sleep(1);
        System.out.println("运行结束...");
    }
}
