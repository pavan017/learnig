package ReaderWriter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/*
A source is locked when we performing write operation we can achieve this by using semaphore or boolean semaphore called mutex

 */



public class Main {
    public static void main(String [] args) throws InterruptedException {
        Operation readOperation = Operation.Read;
        Operation writeOperation = Operation.Write;
        Semaphore semaphore = new Semaphore(1);
        System.out.println("I am here");
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new FileOperation(writeOperation, semaphore));
        service.submit(new FileOperation(writeOperation, semaphore));
        service.submit(new FileOperation(writeOperation, semaphore));
        service.submit(new FileOperation(writeOperation, semaphore));
        Thread.sleep(2000);
        service.submit(new FileOperation(readOperation, semaphore));
        service.submit(new FileOperation(readOperation, semaphore));
        service.submit(new FileOperation(readOperation, semaphore));
        service.submit(new FileOperation(writeOperation, semaphore));
    }
}
