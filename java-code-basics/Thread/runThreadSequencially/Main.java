package runThreadSequencially;

public class Main {
    public static void  main(String [] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am thread 1");

        });
        Thread t2 = new Thread(()-> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am thread 2");
        });
        Thread t3 = new Thread(()-> {
            System.out.println("I am thread 3");
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("I am here");
    }
}
