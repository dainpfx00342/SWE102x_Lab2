package creational.builder.demo;

import creational.builder.builders.CarBuilder;
import creational.builder.builders.CarManualBuilder;
import creational.builder.cars.Car;
import creational.builder.cars.Manual;
import creational.builder.director.Director;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car builder: \n"+car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built: \n"+carManual.print() );
    }
}
