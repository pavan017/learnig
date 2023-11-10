package ConditionClass;

public class Task {
    public static class Task1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Running task 1");
        }
    }

    public static class Task2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Running task 2");
        }
    }


    public static class Task3 implements Runnable {

        @Override
        public void run() {
            System.out.println("Running task 3");
        }
    }

}
