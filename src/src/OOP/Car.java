package OOP;

public class Car {

    String make = "Honda";
    String model = "Civic";
    int year = 2020;
    double price = 10000.15;
    boolean isRunning = false;

    void start(){
        System.out.println("You are starting the engine");
        isRunning = true;
    }

    void stop(){
        System.out.println("You are shutting down the engine");
        isRunning = false;
    }

    void drive(){
        System.out.println("You are driving the " + year + " " + model);
    }

    void brake(){
        System.out.println("You are breaking the " + year + " " + model);
    }
}
