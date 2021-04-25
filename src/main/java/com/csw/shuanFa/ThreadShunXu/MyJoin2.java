package com.csw.shuanFa.ThreadShunXu;

/*改变join()传入的毫秒值，查看执行顺序并分析结果：*/
public class MyJoin2 {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //处理业务时间，模拟为8秒
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1");
            }
        }, "t1");
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join(4000); //t2等待t1线程4秒
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
                    t2.join(2000); //t3等待t2线程2秒
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
/*执行结果：

        线程3	//程序启动过了2秒执行t3
        线程2 //过了4秒执行t2
        线程1 //过了8秒执行t1
        分析：我们让t1 睡眠8秒模拟业务执行时间，t2等待t1 的时间为4秒，
        t3等待t2的时间为2秒。那么当t1，t2，t3启动后，等待的时间，t3会因为t2的等待时间
        4秒太长而先与t2执行，t2会因为t1的8秒太长而先与t1执行。*/
