package ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String [] args) throws ExecutionException, InterruptedException, TimeoutException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        //It's good to have same number of threads in thread pool as number of cpu cores
        System.out.println("Number Of cores= "+coreCount);

//        Fixed thread pool
//             you can use this to create fixed thread pool which you can use to run the task
//             When you submit of a task it will get stored in blocking queue which is thread safe
//             And when thread is avilable in the thread pool it pick the new task from thread pool and start execution

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for(int i=0; i<100; i++) {
//            executorService.execute(new ExecutorServiceTask());
//        }

//        //Cached Thread pool
//              It will incrementally create thread to hold any new task which came up
//              It uses synchronous queue which and holds only one task at a given point of time

//        ExecutorService cachedThreadPoolService = Executors.newCachedThreadPool();
//        for(int i=0; i<100; i++){
//            cachedThreadPoolService.execute(new ExecutorServiceTask());
//        }

        /*
        Scheduled Thread pool
            => it's good for task which you want to schedule after certain delay
            => like if you want to perform some kind of checks after every 10 secs or something like that
            => it uses delay queue to store the task which you wanted to schedule

         */

        ScheduledExecutorService scheduledThreadPoolService = Executors.newScheduledThreadPool(10);

//        //task to run after 10 seconds of delay
//        scheduledThreadPoolService.schedule(new ExecutorServiceTask(), 10, TimeUnit.SECONDS);
//
//        //task to run repeatedly after every 10 sec
//        scheduledThreadPoolService.scheduleAtFixedRate(new ExecutorServiceTask(), 15, 10, TimeUnit.SECONDS);


//        //task to run repeatedly 10 sec after previous task completes
//        scheduledThreadPoolService.scheduleWithFixedDelay(new ExecutorServiceTask(), 15, 10, TimeUnit.SECONDS);


        /*
            Single thread executor
                => it is same as fixed thread pool where pool size is equals 1
                => it is used when you want to insure that task 1 is always run before task 2

         */

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new ExecutorServiceTask());


/*
 Callable Method
    => future is the placeholder for a value which is going to arrieved in future
 */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futureList =  new ArrayList<>();
        for(int i=0; i<10; i++){
            //submit method is a separate method for run a callable task
            Future<String> future = executorService.submit(new CallableTask());
            futureList.add(future);
            System.out.println("Main Callable");

        }
       // System.out.println("Future = "+futureList.get(5).get()); // It's a blocking call
        //you can add a timeout for future.get() method if future is not
        // ready with the result within that time frame then it will unblock the main thread

        futureList.get(5).get(1, TimeUnit.SECONDS);
        System.out.println("i am at end");
    }
}
