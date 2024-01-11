package ScatterGatherPattern;

/*
    Write code to retrieve prices from n sources
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        Set<Integer> prices =  Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Task("amazon.com",1, prices, latch));
        executorService.submit(new Task("flipkart.com",1, prices, latch));
        executorService.submit(new Task("walmart.com",1, prices, latch));
        latch.await();
//        latch.await(3, TimeUnit.SECONDS);

        System.out.println("fetched price count = "+prices.size());
    }
}
