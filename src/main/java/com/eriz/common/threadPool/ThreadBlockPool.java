package com.eriz.common.threadPool;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞模式线程池
 *
 * @author eriz
 * @date 2019年6月20日
 */
public class ThreadBlockPool {
    private final Logger logger = Logger.getLogger(this.getClass());
    ExecutorService exePool;
    private List<Runnable> runnables = new ArrayList<Runnable>();
    private boolean isActivity = true;

    private Integer maxThread = 100;

    private Integer timeOutSeconds = 60;

    public Integer getMaxThread() {
        return maxThread;
    }

    public void setMaxThread(Integer maxThread) {
        this.maxThread = maxThread;
    }

    public ThreadBlockPool() {

    }

    public ThreadBlockPool(Integer maxThread, Integer timeOutSeconds) {
        this.maxThread = maxThread;
        this.timeOutSeconds = timeOutSeconds;
    }

    public ThreadBlockPool(List<Runnable> runnables) {
        this.runnables.addAll(runnables);
    }

    public void execute(List<Runnable> runnables) {
        pushTask(runnables);
        execute();
    }

    public void execute() {
        if (!isActivity) {
            logger.info("ThreadBlockPool >>线程池已销毁");
        }
        isActivity = false;
        if (runnables == null || runnables.isEmpty()) {
            return;
        }
        Integer currThread = runnables.size();
        if (currThread > maxThread) {
            currThread = maxThread;
        }
        exePool = Executors.newFixedThreadPool(maxThread);
        logger.info("ThreadBlockPool >>[" + maxThread + "]执行中");
        for (Runnable runnable : runnables) {
            exePool.execute(runnable);
        }
        exePool.shutdown();
        try {
            exePool.awaitTermination(timeOutSeconds * 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("ThreadBlockPool:[" + maxThread + "]执行完毕");
    }

    public boolean pushTask(List<Runnable> runnables) {
        if (!isActivity) {
            logger.info("ThreadBlockPool >>线程池已销毁");
        }
        this.runnables.addAll(runnables);
        return isActivity;
    }

    public boolean pushTask(Runnable runnable) {
        if (!isActivity) {
            logger.info("ThreadBlockPool >>线程池已销毁");
        }
        runnables.add(runnable);
        return isActivity;
    }

    public static void main(String[] args) {
        List<Runnable> runnables = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            runnables.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前时间" + System.currentTimeMillis());
                }
            });
        }

        ThreadBlockPool threadBlockPool = new ThreadBlockPool();
        threadBlockPool.execute(runnables);
    }
}
