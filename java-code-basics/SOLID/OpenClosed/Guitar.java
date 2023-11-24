package OpenClosed;

public class Guitar {
    private String make;
    private String model;
    private int volume;
}

// We launch application with above class and everyone loves it.
// But after a few months we it become boring and could use some cool flame pattern
// we can open this existing class and add a new property called cool flame but who knows it might throw some exception in our application
// Instead of that we should stick to open close principle and simply extend our guitar class

class SuperCoolGuitarWithFlames extends Guitar {
    private String flameColor;
}
//by this we are sure that our existing application is not affected in any way
