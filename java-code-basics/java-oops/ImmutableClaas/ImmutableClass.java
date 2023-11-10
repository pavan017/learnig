package ImmutableClaas;

import java.util.HashMap;
import java.util.Map;

/*
=> Immutable class in java means that once an object is created then after that we can not change its content
=> All wrapper class(Integer, Boolean) and String class is java is immutable
Following are the requirement
    => The class must be declared as final so that child class can't be created
    => Data Member must be declared as private so that direct access is not allowed
    => Data member must be final so that we can't change the value of it after object creation
    => A parameterized constructor should initialize all the fields performing a deep copy so that
     data members can’t be modified with an object reference.
    => Deep Copy of objects should be performed in the getter methods to
     return a copy rather than returning the actual object reference)

 */
public final class ImmutableClass {
    private final String memberSting;
    private final int memberInt;
    private final Map<String, String> memberMap;

    public ImmutableClass(String memberSting, int memberInt, Map<String, String> map) {
        this.memberSting = memberSting;
        this.memberInt = memberInt;


        Map<String, String> tempMap = new HashMap<>();
        //Creating Deep copy of map
        // Iterating using for-each loop
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.memberMap = tempMap;

    }

    public String getMemberSting() {
        return memberSting;
    }

    public int getMemberInt() {
        return memberInt;
    }

    public Map<String, String> getMemberMap() {
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.memberMap.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
