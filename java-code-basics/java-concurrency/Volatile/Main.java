package Volatile;

/*
1=> Every thread have their local cache and and share cache.
2=> Once we update any volatile variable then it update that value in shared cache and local cache for thread get updated by the value present
shared cache
3=> It's called visibility problem which we try to solve using volatile keyword


 */

public class Main {

    public static void main(String [] args) throws InterruptedException {
        System.out.println("paka");
        ThreadOne threadOne = new ThreadOne(true);
        Thread thread = new Thread(threadOne);
        thread.start();

       Thread.sleep(5000);
        threadOne.flag = false;

    }


}
