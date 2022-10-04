package factories;

import buttons.*;
import checkboxes.*;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOsFactory implements GUIfactory {

    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckbox();
    }
}
