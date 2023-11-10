package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerClass {
    static Lock lock  = new ReentrantLock();
    static Condition produceCondition = lock.newCondition();
    static Condition consumeCondition = lock.newCondition();
    static List<Integer> lst = new ArrayList<>();
    static int maxSize = 5;
    static AtomicInteger i=new AtomicInteger(0);

    public static void main(String [] args) {
        for(int i=0;i<100;i++){
            if(i%2==0){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            produce();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("producing new values in lst");
                    }
                }).start();
            }else{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            consume();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("consuming values from lst");
                    }
                }).start();
            }
        }
    }

    public static synchronized void produce() throws InterruptedException {
        if(lst.size()==maxSize){
//
            consumeCondition.wait();
        }
        lst.add(i.getAndIncrement());
        System.out.println("produced: "+i);

        produceCondition.notify();
    }

    public static synchronized void consume() throws InterruptedException {
        Thread.sleep(5000);
        if(lst.size()==0){
            produceCondition.wait();
        }
        System.out.println("consumed: "+lst.get(0));
        lst.remove(0);

        consumeCondition.notify();
    }
}
