/*
It allows object with incompatible interfaces to collaborate

Have you ever seen a tractor  running on railway track. As tractor is not build to run on railway track but
people use a trolly and add tractor wheel with that trolly to make this work. which is nothing but
tractor to rail adopter


Example
suppose we are working on stock broker application and it suppose to fetch data from different
different source. Those resource return data in xml format and you wanted to use a 3rd party
analytics library and this library only consume data in json format. So the solution to tackle
this kind of problem is nothing but have an adopter which is converting incoming data in XML format
to Json format and pass this data to analytics library

Reference
=============
https://refactoring.guru/design-patterns/adapter


*/


public class Adapter {
    public static void main(String [] args) {
        RoundHole hole = new RoundHole(5.0F);
        RoundPeg rpeg = new RoundPeg(5.0F);
        System.out.println(hole.fits(rpeg)); // true

        SquarePeg small_sqpeg = new SquarePeg(5.0F);
        SquarePeg large_sqpeg = new SquarePeg(10.0F);
//        hole.fits(small_sqpeg) // this won't compile (incompatible types)

        SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
        SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg);
        System.out.println(hole.fits(small_sqpeg_adapter)); // true
        System.out.println(hole.fits(large_sqpeg_adapter)); // false
    }
}



// Say you have two classes with compatible interfaces:
// RoundHole and RoundPeg.
class RoundHole{
    public float radius;
    public boolean fits(RoundPeg peg){
        return this.getRadius() >= peg.getRadius();
    }

    public float getRadius() {
        return radius;
    }

    public RoundHole(float radius) {
        this.radius = radius;
    }
}

class RoundPeg {
    public float radius;

    public RoundPeg(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}


// But there's an incompatible class: SquarePeg.
class SquarePeg {
    public float width;

    public float getWidth() {
        return width;
    }

    public SquarePeg(float width) {
        this.width = width;
    }
}


// An adapter class lets you fit square pegs into round holes.
// It extends the RoundPeg class to let the adapter objects act
// as round pegs.
class SquarePegAdapter extends RoundPeg {
    // In reality, the adapter contains an instance of the
    // SquarePeg class.
    private SquarePeg peg;
    public float getRadius(){
        return (float) (peg.getWidth() * Math.sqrt(2) / 2);
    }
    // The adapter pretends that it's a round peg with a
    // radius that could fit the square peg that the adapter
    // actually wraps.


    public SquarePegAdapter(SquarePeg peg) {
        super(0.0F);
        this.peg = peg;
    }
}



// Somewhere in client code.




