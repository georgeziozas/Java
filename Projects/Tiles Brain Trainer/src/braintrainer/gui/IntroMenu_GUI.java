package braintrainer.gui;

import braintrainer.extra.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public final class IntroMenu_GUI extends JFrame {

    public JPanel contentPane;
    private LeaderboardManager_GUI lm;
    private JMenuBar menuBar;
    private final JButton mainMenu_btn;
    private final JCheckBox easy_checkbox;
    private final JCheckBox medium_checkbox;
    private final JCheckBox hard_checkbox;
    private final JLabel nameLbl;
    private final JLabel diffLvlLbl;
    private final JLabel titleLbl;
    private final JTextField username_field;
    private final ButtonGroup checkBoxGroup;

    //Constructor
    public IntroMenu_GUI() {

        this.setTitle("Brain Trainer");
        this.setSize(500, 400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);
        //pane with null layout
        contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400, 400));
        contentPane.setBackground(new Color(255, 255, 255));

        mainMenu_btn = new JButton();
        mainMenu_btn.setBounds(214, 336, 160, 54);
        mainMenu_btn.setForeground(new Color(0, 102, 204));
        mainMenu_btn.setEnabled(true);
        mainMenu_btn.setFont(new Font("sansserif", 0, 12));
        mainMenu_btn.setText("Proceed to Main Menu");
        mainMenu_btn.setVisible(true);

        mainMenu_btn.addActionListener((evt) -> {
            try {
                this.toMainMenu(evt);
            } catch (Exception ex) {
                Logger.getLogger(IntroMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Invalid info provided try to run again.");
            }
        });

        checkBoxGroup = new ButtonGroup();

        easy_checkbox = new JCheckBox();
        easy_checkbox.setBounds(258, 194, 90, 35);
        easy_checkbox.setForeground(new Color(0, 102, 204));
        easy_checkbox.setEnabled(true);
        easy_checkbox.setFont(new Font("sansserif", 0, 12));
        easy_checkbox.setText("EASY");
        easy_checkbox.setVisible(true);
        checkBoxGroup.add(easy_checkbox);

        medium_checkbox = new JCheckBox();
        medium_checkbox.setBounds(258, 235, 90, 35);
        medium_checkbox.setEnabled(true);
        medium_checkbox.setForeground(new Color(0, 102, 204));
        medium_checkbox.setFont(new Font("sansserif", 0, 12));
        medium_checkbox.setText("MEDIUM");
        medium_checkbox.setVisible(true);
        checkBoxGroup.add(medium_checkbox);

        hard_checkbox = new JCheckBox();
        hard_checkbox.setBounds(258, 277, 90, 35);
        hard_checkbox.setForeground(new Color(0, 102, 204));
        hard_checkbox.setEnabled(true);
        hard_checkbox.setFont(new Font("sansserif", 0, 12));
        hard_checkbox.setText("HARD");
        hard_checkbox.setVisible(true);
        checkBoxGroup.add(hard_checkbox);

        nameLbl = new JLabel();
        nameLbl.setBounds(40, 105, 90, 35);
        nameLbl.setBackground(new Color(214, 217, 223));
        nameLbl.setForeground(new Color(0, 0, 0));
        nameLbl.setEnabled(true);
        nameLbl.setFont(new Font("SansSerif", 0, 16));
        nameLbl.setText("Name");
        nameLbl.setVisible(true);

        diffLvlLbl = new JLabel();
        diffLvlLbl.setBounds(40, 203, 119, 30);
        diffLvlLbl.setBackground(new Color(214, 217, 223));
        diffLvlLbl.setForeground(new Color(0, 0, 0));
        diffLvlLbl.setEnabled(true);
        diffLvlLbl.setFont(new Font("SansSerif", 0, 16));
        diffLvlLbl.setText("Difficulty Level");
        diffLvlLbl.setVisible(true);

        titleLbl = new JLabel();
        titleLbl.setBounds(99, 7, 275, 67);
        titleLbl.setBackground(new Color(214, 217, 223));
        titleLbl.setForeground(new Color(0, 0, 0));
        titleLbl.setEnabled(true);
        titleLbl.setFont(new Font("SansSerif", 0, 36));
        titleLbl.setText("Brain Trainer");
        titleLbl.setVisible(true);

        username_field = new JTextField();
        username_field.setBounds(233, 106, 125, 33);
        username_field.setBackground(new Color(255, 255, 255));
        username_field.setForeground(new Color(0, 0, 0));
        username_field.setEnabled(true);
        username_field.setFont(new Font("sansserif", 0, 12));
        username_field.setText("Provide username");
        username_field.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(mainMenu_btn);
        contentPane.add(easy_checkbox);
        contentPane.add(medium_checkbox);
        contentPane.add(hard_checkbox);
        contentPane.add(nameLbl);
        contentPane.add(diffLvlLbl);
        contentPane.add(titleLbl);
        contentPane.add(username_field);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    //method for generate menu
    public void generateMenu() {
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem about = new JMenuItem("About   ");

        file.add(exit);
        help.add(about);

        menuBar.add(file);
        menuBar.add(help);
    }

    //Method actionPerformed for button1
    private void toMainMenu(ActionEvent evt) throws Exception {

        String diff = "";
        String name = username_field.getText();
        if (name != null) {
            if (easy_checkbox.isSelected()) {
                diff = "EASY";
            } else if (medium_checkbox.isSelected()) {
                diff = "MEDIUM";
            } else if (hard_checkbox.isSelected()) {
                diff = "HARD";
            } else {
                diff = "EASY";
            }
        }
        //TEST System.out.println(name + diff);
        User player = new User(name, diff);
        lm = new LeaderboardManager_GUI();
        lm.addToLeaderboard(player);

        javax.swing.SwingUtilities.invokeLater(() -> {
            MainMenu_GUI mainMenu = new MainMenu_GUI();
            IntroMenu_GUI.super.setVisible(false);
            IntroMenu_GUI.super.dispose();

        });
    }

}
