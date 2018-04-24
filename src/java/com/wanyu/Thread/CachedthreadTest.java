package com.wanyu.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wanyu on 2018/4/4.
 * 可缓存的线程池 如果线程池的大小超过了处理任务所需要的线程
 * 那么就会回收部分空闲的线程 当任务数增加时 此线程池又可以智能的添加新线程来处理任务
 * 此线程池不对线程池大小做限制
 */
public class CachedthreadTest {
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        Thread t1=new Mythreads();
        Thread t2=new Mythreads();
        Thread t3=new Mythreads();
        service.execute(t1);
        service.execute(t2);
        service.execute(t3);
        service.shutdown();
    }
}
class Mythreads extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行");
    }
}
