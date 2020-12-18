package com.hongtian.schedule;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author weed
 * @date 2020/9/24 0024 14:37
 * @description 线程池
 */
@Slf4j
public class ThreadPool {

    private static int coreSize = 10;

    private static int maxSize = 10;

    private ThreadPoolExecutor threadPoolExecutor = null;

    public void init() {
        init(coreSize,maxSize);
    }

    public void init(int core,int max) {
        threadPoolExecutor = new ThreadPoolExecutor(core, max, 10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    public int activeThreadCount(){
        return threadPoolExecutor.getActiveCount();
    }

    public boolean addAble() {
        return activeThreadCount() < threadPoolExecutor.getMaximumPoolSize();
    }

    public boolean excute(Runnable runnable) {
        try{
            threadPoolExecutor.execute(runnable);
            return true;
        }catch (RejectedExecutionException e) {
            log.error("线程池队列已满");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public int coreCount() {
        return threadPoolExecutor.getCorePoolSize();
    }
}
