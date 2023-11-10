package SingletonClass;

public class SingletonClass {
    private static volatile SingletonClass _instance;

    private  SingletonClass() {
        //Private constructor so that no one can call this constructor from outside
    }

    /** * Double checked locking code on Singleton
     * @return Singelton instance
     */



    public static SingletonClass getInstance() {

        //We are doing double-check so that a new thread not go inside synchronized block once instance is already created
        if (_instance == null) { //synchronize only if resource is not initialized
            synchronized (SingletonClass.class) {
                if (_instance == null) {
                    _instance = new SingletonClass();
                    /*
                        here jvm internally doing the following things
                        => construct empty resource
                        => call constructor
                        => assign to rs
                        And they can be performed in any order
                        suppose the constructor does folowing thins only then
                         thread 2 will not construct a new object  to avoid this situation we must use volatile
                         so that jvm will not reorder those instruction.
                            1=> construct empty resource
                            2=> assign to rs

                     */
                }
            }
        }
        return _instance;
    }
}
