package KeyValueDatastore;

import javafx.util.Pair;
import lombok.SneakyThrows;

public class MyRunnable implements Runnable{
    DataStore dataStore;
    public MyRunnable(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("inside thread = "+ dataStore.getValue("key1"));
        Transaction.begin(dataStore);
        dataStore.add(new Pair("key1","Val_2" ));

        Transaction.commit(dataStore);
        Thread.sleep(5000);
        System.out.println("inside thread after commit= "+ dataStore.getValue("key1"));
    }
}
