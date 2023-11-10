package TimeoutThread;
/*
    we want to stop a particular thread after 10 mins
    there is 2 part
        => how you stop a particular thread
        => how you do it after certain timeout
    => the fact is java thread can not be killed they are cooperative in nature you need to ask politely
        either using interrupts or volatile/atomicBoolean

 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeoutThreadClass {
    public static void main(String [] args) {
        Thread thread = new Thread(() -> {

        });
        thread.start();
        // There is no method to stop a thread thread.stop() is deprecated and no longer in use




        //Second thing is we can use thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.shutdown();
        //        => no new method accepted
        //        => previously submitted tasks are executed


//        executorService.shutdownNow()
        //        => no new method accepted
        //        => previously submitted tasks waiting in the queue are returned
        //        => Task being run by the thread are attempted to stop





        // Third option : instead of runnable we can try something like callable
        Callable<?> future = (Callable<?>) executorService.submit(()->{
        });

        // future.cancel(true); => only attempt to stop the thread.
        // it won't give any such guarantee to be stopped


        //4th option: interrupt
        Thread thread1 = new Thread(()->{
           while(!Thread.currentThread().isInterrupted()) {
               //next step
               //keep checking the interrupt and once main thread interrupt this thread will
               // just come out of the while loop and it will be killed
           }
        });
        //stop the thread
        thread1.interrupt();



        // 5th option : use volatile variable





    }
}
