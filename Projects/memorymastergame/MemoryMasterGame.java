package memorymastergame;

/**
 * Ziozas Georgios
 */
public class MemoryMasterGame {

    //main runs on INITIAL THREAD , SWING-UTILS run on EDT , GAME LOOP runs on the custom thread
    public static void main(String[] args) {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(() -> {
            IntroMenu introMenu = new IntroMenu();
        });

    }

}


