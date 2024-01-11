package Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/*
    1=> Atomic integer will do lots of operation on integer atomically. Suppose we have to increment a variable by 1
    Normal integer will be doing following thing to complete this process while atomic integer will do it in one go
        1=> read value
        2=> increment
        3=> update
    2=> Here we can use synchronized keyword when we are increasing Counter so that opnly one thread increase this counter
        at a Particular time
    3=> We can use Atomic  integer insted of normal Integer.
 */

public class Main {
    public static void main(String [] args) {
//        Counter counter = new Counter(0);
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            executor.execute(new IncrementThread(counter));
        }

    }
}
