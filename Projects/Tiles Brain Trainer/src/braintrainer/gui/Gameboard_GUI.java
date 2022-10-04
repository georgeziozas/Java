package braintrainer.gui;

import braintrainer.extra.User;
import braintrainer.shapes.Gameboard;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public final class Gameboard_GUI {

    Gameboard GB;
    private Border border;
    private JFrame frame;
    private JMenuBar menuBar;
    private JPanel containerPane;
    private JPanel milestonesPane;
     private JPanel buttonsPanel;
    public static JLabel triesLeftLbl;
    public static JLabel tilesLeftLbl;

    //Constructor
    public Gameboard_GUI() {
      
        
        GB = Gameboard.getInstance(); //GameBoard instance Initialization
        GB.gameBoardInit(User.diffLvl); //Initialization of the critical variables
        generateMenu(); //menu generate method
        GB.gameBoardFill(); //filling the array with the buttons objects
        gameboardInit(); //creating the jpanels and frames of this GUI class.
        GB.initMilestoneLabels(); //initializing milestone labels.
        gameboardGuiFill(); //filling the jframe with the buttons.
        


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

    /**
     * initialize critical layout and preferences of gui elements
     */
    public void gameboardInit(){
        //Jframe initialization
        frame = new JFrame();
        frame.setTitle("Gameboard GUI");
        frame.setJMenuBar(menuBar);
        //container panel init with default border layout
        containerPane = new JPanel();
        border = BorderFactory.createLineBorder(Color.red, 3);
        //milestones panel with triesLeft and TilesLeft
        milestonesPane = new JPanel();
        milestonesPane.setPreferredSize(new Dimension(220, 600));
        milestonesPane.setBackground(Color.BLACK);
        milestonesPane.setLayout(new BoxLayout(milestonesPane, BoxLayout.Y_AXIS));

        triesLeftLbl = new JLabel();
        triesLeftLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        triesLeftLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        triesLeftLbl.setForeground(Color.WHITE);
        triesLeftLbl.setBorder(border);

        tilesLeftLbl = new JLabel();
        tilesLeftLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        tilesLeftLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        tilesLeftLbl.setForeground(Color.WHITE);
        tilesLeftLbl.setBorder(border);

        milestonesPane.add(Box.createVerticalStrut(300));
        milestonesPane.add(triesLeftLbl);
        milestonesPane.add(Box.createVerticalStrut(20));
        milestonesPane.add(tilesLeftLbl);

        //main game pane with GridLayout
        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(800, 600));
        buttonsPanel.setBackground(Color.red); //test
        buttonsPanel.setLayout(new GridLayout(GB.rows, GB.cols));

        containerPane.add(buttonsPanel);
        containerPane.add(milestonesPane);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //root.add(milestonesPane);
        frame.add(containerPane);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * 
     */
   public void gameboardGuiFill() {
         for (int i = 0; i < GB.board.size(); i++) {
            buttonsPanel.add(GB.board.get(i));
            GB.board.get(i).setBorder(border);
        }
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
        
    }

    /**
     *
     */
    public void setFrame() {
        frame.setVisible(false);
        frame.dispose();
    }
 
}
