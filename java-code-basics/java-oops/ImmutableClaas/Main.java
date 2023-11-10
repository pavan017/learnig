package ImmutableClaas;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        // Main driver method

        // Creating Map object with reference to HashMap
        Map<String, String> map = new HashMap<>();

        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        ImmutableClass immutableClass = new ImmutableClass("ABC", 101, map);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(immutableClass.getMemberSting());
        System.out.println(immutableClass.getMemberInt());
        System.out.println(immutableClass.getMemberMap());

        // Uncommenting below line causes error
        // s.regNo = 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(immutableClass.getMemberMap());
        immutableClass.getMemberMap().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(immutableClass.getMemberMap());
    }
}
