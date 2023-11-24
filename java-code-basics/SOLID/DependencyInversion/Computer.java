package DependencyInversion;

import java.lang.management.MonitorInfo;

public class Computer {
    private StandardKeyboard keyboard;
    private StandardMonitor monitor;

    public Computer() {
        monitor = new StandardMonitor();
        keyboard = new StandardKeyboard();
    }
}

class StandardKeyboard implements Keyboard{
}

class StandardMonitor implements Monitor {
}


/*
Suppose we are having a computer which have bare minimal part like monitor and keyboard.
This computer class work fine and will be able to use standardKeyboard and monitor freely within our Computer Class
But the problem is by Declaring the standard Keyboard and monitor with new Keyword, we have tightly coupled these three classes together
It make computer class hard to test but also we have lost the ability to switch out our standerKeyboard class with a different one
Lets decouple the our computer class from standerdKeyboard By adding a more general KeyBoard interface

 */
