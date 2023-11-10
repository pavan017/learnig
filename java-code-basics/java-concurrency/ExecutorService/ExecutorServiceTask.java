package ExecutorService;

/*
crearting a thread is an expensive task in java
when we are creating a thread in java using for loop it create a new thread and kill that thread after execution
instead of that we can create a thread pool(fix number of thread) and run the task using thread present in that thread poll
what is idea thread pool size =
    => suppose you have a cpu intensive task then it would be good if we can create a thread poll as same
     as number of cpu core you have.
    => suppose you have some task which is io intensive then it would be good to have a bigger thread poll
     otherwise all thread are waiting for io operation and there is no thread to pickup the new task
Type of thread pool
    1=> fixed thread pool
        => it has fixed number of thread and you keep submitting the task to it
        => all task you have submitted is part of queue which is thread safe(blocking queue)

    2=>cache thread pool
        => you don't have fixed number of thread
        => Here yur queue is replaced by something called syncronus queue which have space for single item
        every time if there is new task it will create a new thread and if thread is idle
         for more than perticullar time it will automatically kill that thread
    3=> scheduled thread pool
        you want to perform some kind of checks
        here we have delay queue(similer to priority queue) instead of blocking queue

    4 => single threaded executor
        => size of poll is 1
        => it is used when you want to insure task 1 always runs before task2
        and task2 runs before task3
        => when you want to maintain sequence

How thread pool look like
    thread pool have following parameter
        1=> corePoolSize => initial size/base size
        2=> maxPoolSize => upper threashold for pool size
        3=> keepAliveTime => time for which thread remains idle
            if there is no other task thread pool kill that thread
        4=> workqueue => blocking queue
        5=> thread factory
        6=> handler

fixed thread pool
        1=> corePoolSize => number present in constructor
        2=> maxPoolSize => number present in constructor
        3=> keepAliveTime => 0
        4=> workqueue => blocking queue
        5=> thread factory
        6=> handler
 */

public class ExecutorServiceTask implements Runnable{

    @Override
    public void run() {

        System.out.println("Thread Name:"+ Thread.currentThread().getName());
    }
}
