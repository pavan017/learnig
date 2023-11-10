package ExecutorService;

import java.util.concurrent.Callable;

/*
    what if task wanted to return something. suppose I wanted to return some value there is no way as
    runnable interface having only one method which have return type as void
    So there is any callable interface through which you can return a value


 */


public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        String callableThread  = "callable thread: "+ Thread.currentThread().getName();
        System.out.println(callableThread);
        return callableThread;
    }
}
