package memorymastergame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GameWindow {

    GameBoard GB;
    private Border border;
    private final JFrame frame;
    private JMenuBar menuBar;
    private JPanel containerPane;
    public static JPanel mainPanel;
    private JPanel milestonesPane;
    public static JLabel triesLeftLbl;
    public static JLabel tilesLeftLbl;

    //Constructor
    public GameWindow() {
        GB = GameBoard.getInstance(); //GameBoard instance Initialization
        GB.gameBoardInit(User.diffLvl); //Initialization of the critical variables

        //Jframe and Jpanel initialization
        frame = new JFrame();
        frame.setTitle("GameWindow");

        //menu generate method
        generateMenu();
        frame.setJMenuBar(menuBar);

        //container panel init with default border layout
        containerPane = new JPanel();
        border = BorderFactory.createLineBorder(Color.red, 5);
        //milestones panel with triesLeft and TilesLeft
        milestonesPane = new JPanel();
        milestonesPane.setPreferredSize(new Dimension(200, 600));
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
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setBackground(Color.red); //test
        mainPanel.setLayout(new GridLayout(GB.getRows(), GB.getCols()));

        containerPane.add(mainPanel);
        containerPane.add(milestonesPane);

        GB.gameBoardFill(); //filling the board with the apropriate btns
        GB.initMilestoneLabels();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //root.add(milestonesPane);
        frame.add(containerPane);
        frame.pack();
        frame.setVisible(true);

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

    public JLabel getTriesLeftLbl() {
        return triesLeftLbl;
    }

    public JLabel getTilesLeftLbl() {
        return tilesLeftLbl;
    }
}
