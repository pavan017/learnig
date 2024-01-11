package ScatterGatherPattern;

import lombok.SneakyThrows;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Task implements Runnable{
    String url;
    int productId;
    Set<Integer> prices;
    CountDownLatch latch;

    public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
        this.latch = latch;
    }

    @SneakyThrows
    @Override
    public void run() {
        int price= 0;
//        if(url.equals("amazon.com")){
//            Thread.sleep(1000);
//        }
        prices.add(price);
        latch.countDown();
        System.out.println("I am fetching "+ productId+" from "+ url);
    }
}
