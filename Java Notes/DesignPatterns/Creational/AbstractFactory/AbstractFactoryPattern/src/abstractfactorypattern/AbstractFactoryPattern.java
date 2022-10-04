package abstractfactorypattern;

import buttons.*;
import checkboxes.*;
import factories.GUIfactory;

/**
 *
 * ABOUT -- In this example, buttons and checkboxes will act as products. They
 * have two variants: macOS and Windows. The abstract factory defines an
 * interface for creating buttons and checkboxes. There are two concrete
 * factories, which return both products in a single variant. Client code works
 * with factories and products using abstract interfaces. It makes the same
 * client code working with many product variants, depending on the type of
 * factory object.
 *
 * Applicability -- Use the Abstract Factory when your code needs to work with
 * various families of related products, but you don’t want it to depend on the
 * concrete classes of those products—they might be unknown beforehand or you
 * simply want to allow for future extensibility.
 */
/**
 *
 * @author Ziozas Georgios
 */
public class AbstractFactoryPattern {

    /**
     * Factory users don't care which concrete factory they use since they work
     * with factories and products through abstract interfaces.
     */
    private final Button button;
    private final Checkbox checkbox;

    public AbstractFactoryPattern(GUIfactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
