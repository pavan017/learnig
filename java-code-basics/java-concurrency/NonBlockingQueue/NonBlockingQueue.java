package NonBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NonBlockingQueue<T> {
    int capacity;
    Queue<T> queue;
    Lock lock;
    Condition notFull;
    Condition notEmpty;
    public NonBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();

        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    public void put(T obj){
        System.out.println("i am adding a put operation");
        lock.lock();
        try{
            if(queue.size()==capacity){
                System.out.println("I am at full capacity");
                notFull.await();
            }
            queue.add(obj);
            System.out.println("i am producing = "+ obj.toString());
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try{
            while(queue.size()==0){
                notEmpty.await();
            }
            T item = queue.remove();
            System.out.println("i am comsuming = "+ item.toString());
            notFull.signalAll();
            return item;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
