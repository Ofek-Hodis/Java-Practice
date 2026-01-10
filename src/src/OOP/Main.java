package OOP;

public class Main {

    public static void main(String[] args){
        Car car = new Car();

        car.start();
        System.out.println(car.isRunning);
        car.stop();
        System.out.println(car.isRunning);

        car.drive();
        car.brake();
    }

}
