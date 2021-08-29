package com.csw.algorithm.ThreadShunXu;

/**
 * @description: 问题：现在有 T1、T2、T3 三个线程,怎样保证 T2 在 T1 执行完后执行T3在T2执行完
 * 分析：使用join方法实现
 * @author:wenhuohuo
 */
public class MyJoin {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1");
            }
        }, "t1");
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程2");
            }
        }, "t2");
        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程3");
            }
        }, "t3");
        t3.start();
        t2.start();
        t1.start();
    }
}
/*
执行结果：

        线程1
        线程2
        线程3
        可以看到，我们让t2线程调用t1.join,t3调用t2.join，尽管是t3，t2，t1分别start，
        执行顺序还是t1，t2，t3。是因为join方法底层使用的是wait方法。

        从源码中，我们结合之前的代码分析，t2.join()和t3.join(),均没有传值，相当于join(0),表示不计时间，t2会一直wait等待t1执行完成，t3会一直wait等待t2执行完成。所以执行结果顺序是t3，t2，t1。

2）当传入的毫秒值不为0时，就一直循环等待，直到过了等待时间(dalay<=0)，则执行break方法，那么将不再等待。
*/
