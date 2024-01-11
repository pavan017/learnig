package NonBlockingQueue;

import lombok.SneakyThrows;

public class ConsumerTask implements Runnable{
    NonBlockingQueue queue;

    public ConsumerTask(NonBlockingQueue queue) throws InterruptedException {

        this.queue = queue;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(10000);
        queue.take();
    }
}
