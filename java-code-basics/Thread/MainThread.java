public class MainThread {
    public static void main (String [] args) {
        System.out.println("paka is kaka");
        BasicThread bt = new BasicThread();
        Thread rt = new Thread (new RunnableThread());
        rt.setPriority(1);
        System.out.println("Thread Priority: "+rt.getPriority());
        rt.start();
        bt.start();
        System.out.println("paka");


    }
}