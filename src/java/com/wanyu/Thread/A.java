package com.wanyu.Thread;

import org.junit.Test;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.yield;

/**
 * Created by wanyu on 2018/4/3.
 * 线程组
 */
public class A implements Runnable{
//    public static void main(String[] args) {
//        Thread t1=new Thread(new A());
//        t1.setName("t1线程");
//        t1.start();
//        Thread t2=new Thread(new A());
//        t2.setName("t2线程");
//        t2.start();
//    }
    @Test
    public void test(){
//        Thread thread=new Thread(new A());
//        thread.start();
        ThreadGroup threadGroup=new ThreadGroup("A");
        Thread t1=new Thread(threadGroup,this);
        t1.setName("t1线程");
        t1.start();
        Thread t2=new Thread(threadGroup,this);
        t2.setName("t2线程");
        t2.start();
        Thread td[]=new Thread[threadGroup.activeCount()];//获取线程组中线程的数量
        int count=threadGroup.enumerate(td);//获取线程组中活动的数量
        System.out.println(count);
        for(int i=0;i<count;i++){
            System.out.println(td[i].getName()+"被发现了");
        }
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
