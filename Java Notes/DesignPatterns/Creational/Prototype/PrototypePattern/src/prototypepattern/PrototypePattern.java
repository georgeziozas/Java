package prototypepattern;

import java.util.ArrayList;
import java.util.List;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

/**
 *
 * @author Ziozas Georgios
 */
/**
 * ABOUT --Let’s take a look at how the Prototype can be implemented without the
 * standard Cloneable interface.
 *
 * APPLICABILITY -- (1) Use the Prototype pattern when your code shouldn’t
 * depend on the concrete classes of objects that you need to copy. (2) Use the
 * pattern when you want to reduce the number of subclasses that only differ in
 * the way they initialize their respective objects. Somebody could have created
 * these subclasses to be able to create objects with a specific configuration
 */
public class PrototypePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        circle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
