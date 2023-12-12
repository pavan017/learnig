package VolatileAndAtomic;

public class ThreadOne implements Runnable{
    volatile boolean flag;
    public ThreadOne(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag==true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running current thread");
        }
    }
}



