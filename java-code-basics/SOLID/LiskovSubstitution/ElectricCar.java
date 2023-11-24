package LiskovSubstitution;

public class ElectricCar implements Car{

    @Override
    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    @Override
    public void accelerate() {

    }
}

/*

"Subtype must be suitable for supertype"

As we know that electric car does not have an engine so by implementing car interface for electricCar is violation of Liskov Substitution  principle
As mentioned above we have to throw an exception when we call turnOnEngine for electric car which is changing behaviour of our program
instead of this we have only one method in Car interface which is accelerate and we have to move turn on engine to MoterCar as its relevant to this class only
*/

