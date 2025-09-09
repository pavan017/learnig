public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
        // private constructor to prevent instantiation
    }
    public static Singleton getInstance() {
        if (instance == null) { // Check if instance is null
            synchronized (Singleton.class) { // Synchronize on the class to prevent multiple threads from creating an instance
                if (instance == null) { // Double-check to ensure instance is still null
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
