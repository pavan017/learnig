package ConditionClass;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionClass {
    static Lock lock   =  new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String [] args){



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("doing task 1");
                method1();

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("doing task 2");
                method1();
            }
        });


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    method2();
                 } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        thread1.start();
        thread2.start();
        thread3.start();

    }


    public static void method1() {
        lock.lock();
        try {
            condition.await();
            System.out.println("I got unlocked: method1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Calling method 1");
    }

    public static void method2() {
        lock.lock();
        try {
            System.out.println("before making signal from method2");
            condition.signalAll();
            Thread.sleep(2000);
            System.out.println("i made a signal: method2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Calling method 2");
    }
}
