package KeyValueDatastore;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String [] args) throws InterruptedException {
        DataStore inMemoryDataStore = new DataStore(new HashMap<String, String>());

        Thread th = new Thread(new MyRunnable(inMemoryDataStore));


        inMemoryDataStore.add(new Pair("key1", "value1"));
        System.out.println(inMemoryDataStore.getValue("key1"));

        Transaction.begin(inMemoryDataStore);
        th.start();
        Thread.sleep(2000);
        inMemoryDataStore.add(new Pair("key1", "value_in_transaction"));
        System.out.println(inMemoryDataStore.getValue("key1"));
//        Transaction.rollback(inMemoryDataStore);
        System.out.println(inMemoryDataStore.getValue("key1"));
        Transaction.commit(inMemoryDataStore);



    }
}





class DataStore<T> {
    Map<String, T> store;
    Map<String, T> transactionStore;

    public Map<String, T> getTransactionStore() {
        return transactionStore;
    }


    public Map<String, T> getStore() {
        return this.getStore();
    }

    DataStore(Map<String, T> store){
        this.store = store;
    }

    public T getValue(String key){
        if(this.getTransactionStore() != null && this.transactionStore.containsKey(key)){
            return this.transactionStore.get(key);
        }else{
            return this.store.get(key);
        }
    }

    public void add(Pair<String, T> inputValue){
        if(this.transactionStore != null){
            this.transactionStore.put(inputValue.getKey(), inputValue.getValue());
        }else{
            this.store.put(inputValue.getKey(), inputValue.getValue());
        }

    }

    public void delete(String key){
        this.store.remove(key);
    }

}


class Transaction {
    public static void begin(DataStore dataStore){
        dataStore.transactionStore = new HashMap();

    }

    public static void commit(DataStore dataStore){
        if(dataStore.getTransactionStore() != null){
            dataStore.getTransactionStore().forEach((key, value) -> {
                dataStore.store.put(key, value);
            });
        }


    }

    public static void rollback(DataStore dataStore){
        dataStore.transactionStore = null;
    }


}




