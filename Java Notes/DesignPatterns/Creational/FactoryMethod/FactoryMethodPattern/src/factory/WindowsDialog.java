package factory;

import butons.Button;
import butons.WindowsButton;

/**
 * Windows Dialog will produce windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

}
