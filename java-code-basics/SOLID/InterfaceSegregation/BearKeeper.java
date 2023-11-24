package InterfaceSegregation;

public interface BearKeeper {
    void washTheBear();
    void feedTheBear();
    void petTheBear();
}

//As a zookeeper we are happy to wash and feed the bear but as there is lots of risk involve in petting the bear.
//Unfortunately our interface is large and we have no choice but to implement the code to pet the bear
// Lets fix this by splitting our large interface to divide them into three different interfaces

interface BearCleaner {
    void washTheBear();
}

interface BearFeeder {
    void feedTheBear();
}

interface BearPetter {
    void petTheBear();
}


//Thanks to interface segrigation we are free to implements methods which matters to us as mentioned in BearCarer and CrazyPerson
//
