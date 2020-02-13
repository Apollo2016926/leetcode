package com.eden.explore.datastructure.arrayandstring;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ABATest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(1);
        new Thread(()->{
            int value=atomicInteger.get();
            System.out.println("thread 1 read value: "+value);
            //阻塞1s
            LockSupport.parkNanos(1000000000L);
            if(atomicInteger.compareAndSet(value,3)){
                System.out.println("thread 1 update from "+value+" to 3");
            }else {
                System.out.println("thread 1 update fail!");
            }
        }).start();

        new Thread(()->{
            int value=atomicInteger.get();
            System.out.println("thread 2 read value: "+value);
            if(atomicInteger.compareAndSet(value,2)){
                System.out.println("thread 2 update from "+value+" to 2");
                value=atomicInteger.get();
                System.out.println("thread 2 read value: "+value);
                if (atomicInteger.compareAndSet(value,1)){
                    System.out.println("thread 2 update from "+value+" to 1");
                }
            }
        }).start();

    }
}

