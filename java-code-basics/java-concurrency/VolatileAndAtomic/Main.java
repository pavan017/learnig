package VolatileAndAtomic;

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
