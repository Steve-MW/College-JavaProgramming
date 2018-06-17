//import java.util.*;

public class Testing 
{
    public static void main( String args[] )
    {
        Tesla modelTruck = new Tesla();
        modelTruck.calculateSpeed();
        modelTruck.displaySpeed();

        BMW modelCar = new BMW();
        modelCar.calculateSpeed(100, 20);
        modelCar.displaySpeed();

    }
}

abstract class car
{
    int wheelSize;
    char carName;
    float testDistance, testTime;
    float speed;
    abstract void calculateSpeed(int x, int y);
    void displaySpeed()
    {
        System.out.println("The speed is = " + speed );
    }
}

interface truck
{
    int wheelSize = 29;
    String truckName = "tesla";
    float testDistance = 100;
    float testTime = 20;
    void calculateSpeed();
    void displaySpeed();
}

class BMW extends car
{
    int wheelSize = 20;
    String carName = "M4Coupe";
    void calculateSpeed( int x, int y)
    {
        testDistance = x;
        testTime = y;
        speed = testDistance/testTime;
    }

}

class Tesla implements truck
{
    float speed;
    public void calculateSpeed()
    {
        
        speed = testDistance/testTime;

    }

    public void displaySpeed()
    {
        System.out.println("The speed is = " + speed );
    }
}

