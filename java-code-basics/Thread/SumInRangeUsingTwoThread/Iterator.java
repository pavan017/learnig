package SumInRangeUsingTwoThread;
public class Iterator implements Runnable {
    int [] arr;
    int current;
    int steps;
    int maxIndx;
    int sum;


    public Iterator(int []arr, int current, int steps, int maxIndx) {
        this.arr = arr;
        this.current = current;
        this.steps = steps;
        this.maxIndx = maxIndx;

    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        while(current<maxIndx){
            sum+=arr[current];
            System.out.println(this.current +"       "+this.sum);
            current += steps;
        }
    }
}