package CompletableFeature;

/*

 Perform possible asynchronous(non-blocking) computation and trigger dependent computation which could also be async

 => Suppose you want to perform a workflow which include multiple setup to complete the entire workflow
  For example you want to perform order dispatchment flow
    => fetch order
    => enrich order
    => payment
    => dispatch
    => send email

 You wanted to submit a workflow to single thread and other order will not be disrupted by delay in other order

 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFeatureClass {

/*
    ExecutorService service  = Executors.newFixedThreadPool(10);
    Future<Order> future = service.submit(getOrderTask());
    Order order  = future.get(); // blocking call

    Future<Order> future1 = service.submit(enrichOrderTask());
    Order order  = future1.get(); // blocking call

    Future<Order> future2 = service.submit(paymentOrderTask());
    Order order  = future2.get(); // blocking call

    Future<Order> future3 = service.submit(dispatchOrderTask());
    Order order  = future3.get(); // blocking call

    Future<Order> future4 = service.submit(sendEmailOrderTask());
    Order order  = future4.get(); // blocking call

*/

    /*
    suppose for example we wanted to submit this multiple task in a loop then we have to wait for
    complition of first task and then after that we can start next task 2 and 3 and so on
    as we are using blocking operation future.get it block to main thread to process further until the
    we complete the process and get the result using future.get call.

    So it wont scale further as it like sequential operation which has to wait
     for existing running operation to be completed
   */

    /*
    for(int i=0; i<100; i++){
        CompletableFuture.supplyAsync(() -> getOrder())
                .thenApply(order -> enrich(order))
                .thenApply(order -> performPaymant())
                .thenApply(order -> dispatch(order))
                .thenAccept(order -> sendEmail(order));
    }
    */


    /*
        To tackle this kind of requirement we have completable future which run entire workflow
         asyncronously without bothering the main thread


         We can pass thread pool as second argument in supplyAsync method and we are not passing anything
         then it uses fork-join thread poll as default option
     */

}
