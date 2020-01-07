package memorymastergame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainMenu extends JFrame {

    private LeaderboardManager ltm;
    private JMenuBar menuBar;
    private final JButton startGameBtn;
    private final JButton pauseGameBtn;
    private final JButton exitGameBtn;
    private final JButton showLeaderboardBtn;
    private final JButton rulesBtn;
    private final JButton aboutBtn;
    private int pausedFlag = -1;

    //Constructor
    public MainMenu() {

        this.setTitle("MemoryMasterGame");
        this.setSize(557, 415);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(557, 415));
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
        contentPane.add(pauseGameBtn);
        contentPane.add(exitGameBtn);
        contentPane.add(showLeaderboardBtn);
        contentPane.add(rulesBtn);
        contentPane.add(aboutBtn);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    //Method actionPerformed for button1
    private void startGame(ActionEvent evt) {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameWindow GW = new GameWindow();
            startGameBtn.setEnabled(false);
        });
    }

    //Method actionPerformed for pause_game_btn
    private void pauseGame(ActionEvent evt) {
        this.pausedFlag++;
        if (this.pausedFlag % 2 == 0) {
            for (int i = 0; i < GameBoard.GameBoardInstance.getRows(); i++) {
                for (int j = 0; j < GameBoard.GameBoardInstance.getCols(); j++) {
                    GameBoard.GameBoardInstance.getGameBoard().get(i).get(j).setEnabled(false);
                }
            }
            this.pauseGameBtn.setText("RESUME GAME");
        } else if (this.pausedFlag % 2 == 1) {
            for (int i = 0; i < GameBoard.GameBoardInstance.getRows(); i++) {
                for (int j = 0; j < GameBoard.GameBoardInstance.getCols(); j++) {
                    GameBoard.GameBoardInstance.getGameBoard().get(i).get(j).setEnabled(true);
                }
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
                LeaderboardManager LBM = new LeaderboardManager();
                LBM.showLeaderboard();
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
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
        String infoMessage = "created by Ziozas Georgios ";
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
