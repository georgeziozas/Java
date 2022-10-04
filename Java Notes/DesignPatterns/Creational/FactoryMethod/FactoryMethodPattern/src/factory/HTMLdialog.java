package factory;

import butons.Button;
import butons.HTMLbutton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HTMLdialog extends Dialog {

    @Override
    public Button createButton() {
        return new HTMLbutton();
    }
}
