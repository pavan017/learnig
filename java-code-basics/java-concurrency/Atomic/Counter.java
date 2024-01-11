package Atomic;

public class Counter {
    int count;

    public Counter(int count) {
        this.count = count;
    }

    public void increment(){
        count++;
    }

    public int getCount() {
        return this.count;
    }
}
