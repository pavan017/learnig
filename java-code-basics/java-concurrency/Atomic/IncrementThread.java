package Atomic;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementThread implements Runnable{
//    Counter counter;
    AtomicInteger counter;
    public IncrementThread(AtomicInteger counter) {
        this.counter = counter;
    }

    @SneakyThrows
    @Override
    public void run() {
//        System.out.println("Counter  = "+counter);

/*
         synchronized (counter) {
            counter.increment();
            Thread.sleep(300);
            System.out.println("Counter  = "+counter.getCount()+" "+Thread.currentThread().getName());
        }
*/
        System.out.println("Counter  = "+counter.incrementAndGet()+" "+Thread.currentThread().getName());
    }
}
