package ReaderWriter;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class FileOperation implements Runnable{
    Operation operation;
    Semaphore semaphore;
    public FileOperation(Operation operation, Semaphore semaphore) {
        this.operation = operation;
        this.semaphore = semaphore;
    }

    @SneakyThrows
    @Override
    public void run() {
        if(operation.equals(Operation.Write)){
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println("I am writing");
        }else{
            Thread.sleep(1000);
            System.out.println("I am reading");
        }
        semaphore.release();
    }
}
