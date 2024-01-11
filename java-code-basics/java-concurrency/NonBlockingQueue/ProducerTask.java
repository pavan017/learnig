package NonBlockingQueue;

public class ProducerTask implements Runnable{
    NonBlockingQueue queue;
    String value;

    public ProducerTask(NonBlockingQueue queue, String value) {
        this.queue = queue;
        this.value = value;
    }

    @Override
    public void run() {
        queue.put(value);

    }
}
