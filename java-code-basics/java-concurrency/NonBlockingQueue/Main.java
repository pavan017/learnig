package NonBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        NonBlockingQueue queue = new NonBlockingQueue(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            System.out.println("inside for loop");
            if(i%2==0){
                System.out.println("inside even for loop");
                executorService.submit(new ConsumerTask(queue));
            }else{
                System.out.println("I am initiating the thread");
                executorService.submit(new ProducerTask(queue, Integer.toString(i)));
            }
        }
    }
}
