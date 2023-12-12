package printNNumberViaTwoThread;

import lombok.SneakyThrows;

/*
 Given an integer N, the task is to write java program to print then first N natural number in increasing order


 */
public class Printer implements Runnable {
    private int step; //increment
    private State state;
    private int currentValue;
    private PrinterType currentPrinterType;
    private PrinterType nextPrinterType;
    private int maxValue;

    public Printer(int step, State state, int currentValue, PrinterType currentPrinterType, PrinterType nextPrinterType, int maxValue) {
        this.step = step;
        this.state = state;
        this.currentValue = currentValue;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }


    @SneakyThrows
    @Override
    public void run() {
        while(currentValue <= maxValue){
            synchronized (state){
                while(this.currentPrinterType != state.getNextToPrint()){
                    state.wait();
                }
                System.out.println(currentPrinterType.toString() +"    "+currentValue);
                currentValue+=step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }

    }
}
