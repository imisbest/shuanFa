package com.csw.algorithm.ThreadAndBingFa.FangFaYanShi;

public class ThreadClassDemo {
    public static void main(String[] args) {
        //线程1
        Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);//将该线程标记为守护线程或用户线程。
        thread1.setName("hello");
        System.out.println("Starting hello thread...");
        thread1.start();
        //线程2
        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);//更改线程的优先级
        thread2.setDaemon(true);
        System.out.println("Starting goodbye thread...");
        thread2.start();
        //线程3
        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        //线程4
        System.out.println("Starting thread4...");
        Thread thread4 = new GuessANumber(75);
        thread4.start();
        System.out.println("main() is ending...");
    }
}
