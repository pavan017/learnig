package SumInRangeUsingTwoThread;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        int [] arr = new int[] {2,3,45,8,9,10,3,4};
        int start =2;
        int end = 5;
        int rangeSum = 0;
        Iterator firstIterator = new Iterator(arr, start, 2, end);
        Iterator secondIterator = new Iterator(arr, start+1, 2, end);

        Thread firstThread = new Thread(firstIterator);
        Thread secondThread = new Thread(secondIterator);

        firstThread.start();
        secondThread.start();
        firstThread.join();
        System.out.println("first thread sum "+firstIterator.getSum());
        rangeSum+=firstIterator.getSum();
        secondThread.join();
        System.out.println("second thread sum "+secondIterator.getSum());
        rangeSum += secondIterator.getSum();
        System.out.println("Sum = "+rangeSum);
    }
}


