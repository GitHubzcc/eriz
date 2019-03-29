package com.eriz.localTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

    private volatile boolean isRuning = true;

    int num;

    public void setNum(int num) {
        setRuning(true);
        this.num = num;
    }

    public void setRuning(boolean runing) {
        isRuning = runing;
    }

    @Override
    public void run() {
        System.out.println("线程启动");
        while (isRuning) {
            int a = 2, b = 5;
            int c = a + b;
            num = c;

        }

        System.out.println("我停止了:" + num);
    }

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        try {
//            Thread.sleep(1000);
//            myThread.setRuning(false);
//            System.out.println("false 停止");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        ThreadPoolExecutor threadPoolExecutor;
//        Join join = new Join();
//        join.start();
//        try {
//            join.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("我想后执行");

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 14, 1, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(5));

//        for (int i = 0; i < 5; i++) {
//            MyTask myTask = new MyTask(i);
//            threadPoolExecutor.execute(myTask);
//            System.out.println("线程池中线程数目：" + threadPoolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" +
//                    threadPoolExecutor.getQueue().size() + "，已执行玩别的任务数目：" + threadPoolExecutor.getCompletedTaskCount());
//        }
//        threadPoolExecutor.shutdown();
//        System.out.println(-1 << Integer.SIZE - 3);

        String str1 = "121";
        StringBuffer str2 = new StringBuffer(str1);
        str2.reverse();
        str2.length();
        int aa = 1;
        String strings[] = {"",""};
        int a = strings.length;
        for (int i = 0;i<str1.length();i++){
            if (str1.charAt(i) != str2.charAt(i)){
                System.out.println("不是回文数字");
            } else {
                System.out.println("是回文");
            }
        }


    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行得任务：" + this.taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.taskNum + "任务执行完毕");
    }
}

class Join extends Thread {
    @Override
    public void run() {
        System.out.println("我想先执行");
        super.run();
    }
}


class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                //如果去掉hread.sleep(2000)，那么运行结果就会显示为同步的效果
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

}


class Thread2 extends Thread {
    private HasSelfPrivateNum setNum;

    public Thread2(HasSelfPrivateNum setNum) {
        this.setNum = setNum;
    }

    @Override
    public void run() {
        super.run();
        setNum.addI("b");
    }
}