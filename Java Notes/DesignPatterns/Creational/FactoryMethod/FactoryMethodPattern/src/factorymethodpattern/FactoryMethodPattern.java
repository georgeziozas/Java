package factorymethodpattern;

import factory.Dialog;
import factory.HTMLdialog;
import factory.WindowsDialog;

/**
 * ABOUT -- Production of cross-platform GUI elements In this example, Buttons
 * play a product role and dialogs act as creators. Different types of dialogs
 * require their own types of elements. That’s why we create a subclass for each
 * dialog type and override their factory methods. Each dialog type will
 * instantiate proper button classes. Base dialog works with products using
 * their common interface, that’s why its code remains functional after all
 * changes.
 *
 * APPLICABILITY -- (1) Use the Factory Method when you don’t know beforehand
 * the exact types and dependencies of the objects your code should work with.
 * (2) Use the Factory Method when you want to provide users of your library or
 * framework with a way to extend its internal components. (3) Use the Factory
 * Method when you want to save system resources by reusing existing objects
 * instead of rebuilding them each time.
 *
 * @author Ziozas Georgios
 */
public class FactoryMethodPattern {

    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HTMLdialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
