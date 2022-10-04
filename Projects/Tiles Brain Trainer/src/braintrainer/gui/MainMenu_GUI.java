package braintrainer.gui;

import braintrainer.shapes.Gameboard;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public final class MainMenu_GUI  {

    Gameboard_GUI gameboard_GUI;
    private JFrame frame;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private final JButton startGameBtn;
    private final JButton abandonGameBtn;
    private final JButton pauseGameBtn;
    private final JButton exitGameBtn;
    private final JButton showLeaderboardBtn;
    private final JButton rulesBtn;
    private final JButton aboutBtn;
    private int pausedFlag = -1;

    //Constructor
    public MainMenu_GUI() {
        frame = new JFrame();
        frame.setTitle("MemoryMasterGame");
        frame.setSize(800, 500);
        //menu generate method
        generateMenu();
        frame.setJMenuBar(menuBar);

        //pane with null layout
        contentPane = new JPanel(new GridLayout(7,1));
        contentPane.setPreferredSize(new Dimension(550, 415));
        contentPane.setBackground(new Color(255, 255, 255));

        startGameBtn = new JButton();
        startGameBtn.setBounds(210, 25, 131, 35);
        startGameBtn.setBackground(new Color(214, 217, 223));
        startGameBtn.setForeground(new Color(0, 0, 0));
        startGameBtn.setEnabled(true);
        startGameBtn.setFont(new Font("sansserif", 0, 12));
        startGameBtn.setText("START GAME");
        startGameBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        startGameBtn.addActionListener(this::startGame);

        
        abandonGameBtn = new JButton();
        abandonGameBtn.setBounds(210, 25, 131, 35);
        abandonGameBtn.setBackground(new Color(214, 217, 223));
        abandonGameBtn.setForeground(new Color(0, 0, 0));
        abandonGameBtn.setEnabled(true);
        abandonGameBtn.setFont(new Font("sansserif", 0, 12));
        abandonGameBtn.setText("ABANDON GAME");
        abandonGameBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        abandonGameBtn.addActionListener(this::abandonGame);
        
        
        pauseGameBtn = new JButton();
        pauseGameBtn.setBounds(210, 93, 131, 35);
        pauseGameBtn.setBackground(new Color(214, 217, 223));
        pauseGameBtn.setForeground(new Color(0, 0, 0));
        pauseGameBtn.setEnabled(true);
        pauseGameBtn.setFont(new Font("sansserif", 0, 12));
        pauseGameBtn.setText("PAUSE GAME");
        pauseGameBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        pauseGameBtn.addActionListener(this::pauseGame);

        exitGameBtn = new JButton();
        exitGameBtn.setBounds(210, 163, 131, 35);
        exitGameBtn.setBackground(new Color(214, 217, 223));
        exitGameBtn.setForeground(new Color(0, 0, 0));
        exitGameBtn.setEnabled(true);
        exitGameBtn.setFont(new Font("sansserif", 0, 12));
        exitGameBtn.setText("EXIT GAME");
        exitGameBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        exitGameBtn.addActionListener(this::exitGame);

        showLeaderboardBtn = new JButton();
        showLeaderboardBtn.setBounds(192, 228, 169, 32);
        showLeaderboardBtn.setBackground(new Color(214, 217, 223));
        showLeaderboardBtn.setForeground(new Color(0, 0, 0));
        showLeaderboardBtn.setEnabled(true);
        showLeaderboardBtn.setFont(new Font("sansserif", 0, 12));
        showLeaderboardBtn.setText("SHOW LEADERBOARD");
        showLeaderboardBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        showLeaderboardBtn.addActionListener(this::showLeaderboard);

        rulesBtn = new JButton();
        rulesBtn.setBounds(210, 291, 131, 35);
        rulesBtn.setBackground(new Color(214, 217, 223));
        rulesBtn.setForeground(new Color(0, 0, 0));
        rulesBtn.setEnabled(true);
        rulesBtn.setFont(new Font("sansserif", 0, 12));
        rulesBtn.setText("RULES");
        rulesBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        rulesBtn.addActionListener(this::rules);

        aboutBtn = new JButton();
        aboutBtn.setBounds(210, 350, 131, 35);
        aboutBtn.setBackground(new Color(214, 217, 223));
        aboutBtn.setForeground(new Color(0, 0, 0));
        aboutBtn.setEnabled(true);
        aboutBtn.setFont(new Font("sansserif", 0, 12));
        aboutBtn.setText("ABOUT");
        aboutBtn.setVisible(true);
        //Set action for button click
        //Call defined method
        aboutBtn.addActionListener(this::about);

        //adding components to contentPane panel
        contentPane.add(startGameBtn);
        contentPane.add(abandonGameBtn);
        contentPane.add(pauseGameBtn);
        contentPane.add(exitGameBtn);
        contentPane.add(showLeaderboardBtn);
        contentPane.add(rulesBtn);
        contentPane.add(aboutBtn);
        contentPane.repaint();
        contentPane.revalidate();
        
        //adding panel to JFrame and seting of window position and close operation
        frame.getContentPane().add(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    //Method actionPerformed for startGame
    private void startGame(ActionEvent evt) {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(() -> {
             gameboard_GUI = new Gameboard_GUI();
            startGameBtn.setEnabled(false);
            abandonGameBtn.setEnabled(true);
        });
    }
    
    //Method actionPerformed for startGame
     private void abandonGame(ActionEvent evt) {
       gameboard_GUI.setFrame();
       Gameboard.setInstance();
       startGameBtn.setEnabled(true);
       abandonGameBtn.setEnabled(false);

       
    }
     
    //Method actionPerformed for pause_game_btn
    private void pauseGame(ActionEvent evt) {
        this.pausedFlag++;
        if (this.pausedFlag % 2 == 0) {
            for (int i = 0; i < Gameboard.GameBoardInstance.rows*Gameboard.GameBoardInstance.cols; i++) {
               Gameboard.GameBoardInstance.board.get(i).setEnabled(false);
            }
            this.pauseGameBtn.setText("RESUME GAME");
        } else if (this.pausedFlag % 2 == 1) {
            for (int i = 0; i < Gameboard.GameBoardInstance.rows*Gameboard.GameBoardInstance.cols; i++) {
               Gameboard.GameBoardInstance.board.get(i).setEnabled(true);
            }
            this.pauseGameBtn.setText("PAUSE GAME");
        }
    }
    
    //Method actionPerformed for exit_btn
    private void exitGame(ActionEvent evt) {
        System.exit(0);
    }

    //Method actionPerformed for show_leaderboard_btn
    private void showLeaderboard(ActionEvent evt) {

        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                LeaderboardManager_GUI LBM = new LeaderboardManager_GUI();
                LBM.showLeaderboard();
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MainMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    //Method actionPerformed for rules_button
    private void rules(ActionEvent evt) {
        String infoMessage = "Memory puzzle game \n Click each Tile to reveal the shape underneath it , find all the pairs to win the game \n"
                + "but be carefull , you only have a specific number of lives. \n 3 Levels : EASY : 3 lives , MEDIUM : 5 lives , HARD : 8 Lives."
                + " \n Find the JOKER !! special prizes awaiting you. ";
        JOptionPane.showMessageDialog(null, infoMessage, "Rules", JOptionPane.INFORMATION_MESSAGE);
    }

    //Method actionPerformed for about_button
    private void about(ActionEvent evt) {
        String infoMessage = "created by ziozas georgios";
        JOptionPane.showMessageDialog(null, infoMessage, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    //method for generate menu
    public void generateMenu() {
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }

}
