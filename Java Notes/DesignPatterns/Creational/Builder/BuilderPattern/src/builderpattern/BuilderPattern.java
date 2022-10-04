package builderpattern;

import builders.CarBuilder;
import builders.CarManualBuilder;
import cars.Car;
import cars.Manual;
import directors.Director;

/**
 *
 * @author Ziozas Georgios
 */
/**
 * ABOUT -- In this example, the Builder pattern allows step by step
 * construction of different car models. The example also shows how Builder
 * produces products of different kinds (car manual) using the same building
 * steps. The Director controls the order of the construction. It knows which
 * building steps to call to produce this or that car model. It works with
 * builders only via their common interface. This allows passing different types
 * of builders to the director. The end result is retrieved from the builder
 * object because the director can’t know the type of resulting product. Only
 * the Builder object knows what exactly does it builds.
 *
 * APPLICABILITY -- (1)Use the Builder pattern to get rid of a “telescopic
 * constructor”. (2) Use the Builder pattern when you want your code to be able
 * to create different representations of some product (for example, stone and
 * wooden houses). (3)Use the Builder to construct Composite trees or other
 * complex objects.
 *
 */
public class BuilderPattern {

    /**
     * main class. Everything comes together here.
     *
     * @param args
     */
    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }

}
