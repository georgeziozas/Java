
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


public class IntroMenu extends JFrame {

    private LeaderboardManager ltm;
    private JMenuBar menuBar;
    private JButton mainMenu_btn;
    private JCheckBox easy_checkbox;
    private JCheckBox medium_checkbox;
    private JCheckBox hard_checkbox;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField username_field;
    private ButtonGroup checkBoxGroup;
    //Constructor 
    public IntroMenu(){

        this.setTitle("GUI_project");
        this.setSize(500,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,400));
        contentPane.setBackground(new Color(255,255,255));


        mainMenu_btn = new JButton();
        mainMenu_btn.setBounds(214,336,160,54);
        mainMenu_btn.setForeground(new Color(0,102,204));
        mainMenu_btn.setEnabled(true);
        mainMenu_btn.setFont(new Font("sansserif",0,12));
        mainMenu_btn.setText("Proceed to Main Menu");
        mainMenu_btn.setVisible(true);

        checkBoxGroup = new ButtonGroup();
        
        easy_checkbox = new JCheckBox();
        easy_checkbox.setBounds(258,194,90,35);
        easy_checkbox.setForeground(new Color(0,102,204));
        easy_checkbox.setEnabled(true);
        easy_checkbox.setFont(new Font("sansserif",0,12));
        easy_checkbox.setText("EASY");
        easy_checkbox.setVisible(true);
        checkBoxGroup.add(easy_checkbox);
        
        medium_checkbox = new JCheckBox();
        medium_checkbox.setBounds(258,235,90,35);
        medium_checkbox.setEnabled(false);
        medium_checkbox.setForeground(new Color(0,102,204));
        medium_checkbox.setFont(new Font("sansserif",0,12));
        medium_checkbox.setText("MEDIUM");
        medium_checkbox.setVisible(true);
        checkBoxGroup.add(medium_checkbox); 
        
        hard_checkbox = new JCheckBox();
        hard_checkbox.setBounds(258,277,90,35);
        hard_checkbox.setForeground(new Color(0,102,204));
        hard_checkbox.setEnabled(false);
        hard_checkbox.setFont(new Font("sansserif",0,12));
        hard_checkbox.setText("HARD");
        hard_checkbox.setVisible(true);
        checkBoxGroup.add(hard_checkbox);
        
        label1 = new JLabel();
        label1.setBounds(40,105,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,16));
        label1.setText("Name");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(40,203,119,30);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Difficulty Level");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(99,7,275,67);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,36));
        label3.setText("MemoryMaster");
        label3.setVisible(true);

        username_field = new JTextField();
        username_field.setBounds(233,106,125,33);
        username_field.setBackground(new Color(255,255,255));
        username_field.setForeground(new Color(0,0,0));
        username_field.setEnabled(true);
        username_field.setFont(new Font("sansserif",0,12));
        username_field.setText("Provide username");
        username_field.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(mainMenu_btn);
        contentPane.add(easy_checkbox);
        contentPane.add(medium_checkbox);
        contentPane.add(hard_checkbox);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(username_field);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //method for generate menu
    public void generateMenu(){
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



	 public static void main(String[] args){
		//System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new IntroMenu();
			}
		});
	}

}

//TODO
//pernw to username apo to textfield static username
//pernw tin epilogi apo ta checkbox group
//me to patima tou main menu -> dimiourgo xristi me ta xaraktiristika tou
//ton grafo sto arxeio txt.
//kai telos panw sto mainmenu
