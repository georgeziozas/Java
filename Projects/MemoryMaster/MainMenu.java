/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class MainMenu extends JFrame {
    
    private LeaderboardManager ltm;
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    //Constructor 
    public MainMenu(){

        this.setTitle("GUI_project");
        this.setSize(557,415);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(557,415));
        contentPane.setBackground(new Color(255,255,255));


        button1 = new JButton();
        button1.setBounds(210,25,131,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("START GAME");
        button1.setVisible(true);
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startGame(evt);
            }
        });


        button2 = new JButton();
        button2.setBounds(210,93,131,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("PAUSE GAME");
        button2.setVisible(true);
        //Set action for button click
        //Call defined method
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pauseGame(evt);
            }
        });


        button3 = new JButton();
        button3.setBounds(210,163,131,35);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("EXIT GAME");
        button3.setVisible(true);
        //Set action for button click
        //Call defined method
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitGame(evt);
            }
        });


        button4 = new JButton();
        button4.setBounds(192,228,169,32);
        button4.setBackground(new Color(214,217,223));
        button4.setForeground(new Color(0,0,0));
        button4.setEnabled(true);
        button4.setFont(new Font("sansserif",0,12));
        button4.setText("SHOW LEADERBOARD");
        button4.setVisible(true);
        //Set action for button click
        //Call defined method
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showLeaderboard(evt);
            }
        });


        button5 = new JButton();
        button5.setBounds(210,291,131,35);
        button5.setBackground(new Color(214,217,223));
        button5.setForeground(new Color(0,0,0));
        button5.setEnabled(true);
        button5.setFont(new Font("sansserif",0,12));
        button5.setText("RULES");
        button5.setVisible(true);
        //Set action for button click
        //Call defined method
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rules(evt);
            }
        });


        button6 = new JButton();
        button6.setBounds(210,350,131,35);
        button6.setBackground(new Color(214,217,223));
        button6.setForeground(new Color(0,0,0));
        button6.setEnabled(true);
        button6.setFont(new Font("sansserif",0,12));
        button6.setText("ABOUT");
        button6.setVisible(true);
        //Set action for button click
        //Call defined method
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                about(evt);
            }
        });


        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        contentPane.add(button5);
        contentPane.add(button6);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for button1
    private void startGame (ActionEvent evt) {
            //TODO
    }

    //Method actionPerformed for button2
    private void pauseGame (ActionEvent evt) {
            //TODO
    }

    //Method actionPerformed for button3
    private void exitGame (ActionEvent evt) {
            //TODO
    }

    //Method actionPerformed for button4
    private void showLeaderboard (ActionEvent evt) {
            //TODO
    }

    //Method actionPerformed for button5
    private void rules (ActionEvent evt) {
            //TODO
    }

    //Method actionPerformed for button6
    private void about (ActionEvent evt) {
            //TODO
    }

    //method for generate menu
    public void generateMenu(){
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



     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu();
            }
        });
    }

}