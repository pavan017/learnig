package DependencyInversion;

public class RefineComputer {
    private Keyboard keyboard;
    private Monitor monitor;

    public RefineComputer(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}

/*
Now here we are using dependency injection pattern to facilitate by adding the keyboard dependency into the refine computer class
Lets modify StandardMonitor and StandardKeyboard class so that it suitable for injecting into the computer class
Now our class are decoupled and communicate through the keyboard abstraction if we want we can eaisly switch between different kind of
keyboard and monitor implementation

 */

