package simplemahjong.GUI;

import simplemahjong.Game.Board;
import simplemahjong.Game.Player;
import simplemahjong.Game.generalTypeTile;
import simplemahjong.Tiles.Tiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

/**
 * Class GameForm description.
 *
 * @desc GameForm contains the front end design , game logic , association of buttons and information of the Tiles.
 */

public class GameForm implements ActionListener
{
    int numFreeTiles=124;
    private static int maxTempMapSize = 2;      /* the size of the map which hold the 2last clicks of the user */
    private static Map<JToggleButton, Tiles> buttonBoard = new HashMap<>(54); /* this map holds all the btns on the board as keys and as values all the info of each Tile associated with each BTN. */

    private static LinkedHashMap<JToggleButton, Tiles> tempMap = new LinkedHashMap<>(maxTempMapSize); /* this map will always hold the latest pair of 2 btns the user clicks (can search by index). */
    private List<Tiles> tempMapToList = new ArrayList<>(tempMap.values());  /* this list of tiles takes the tempMap and chnages it to list so i can search based on index. */
    private List<JToggleButton> listOfKeysToDelete = new ArrayList<>(2); /*  in this list of buttons i hold the keys of the values that must be deleted. */
    private List<JToggleButton> undolistOfKeys = new ArrayList<>(2);

    private static LinkedHashMap<JToggleButton, Tiles> guessNextMovetempMap = new LinkedHashMap<>(2);
    private static List<Tiles> guessNextMovetempMapToList = new ArrayList<>(guessNextMovetempMap.values());
    private ImageOfTiles imgOfTilesPath; /* object of the imageoftiles class containing a hashmap of <image,buttons> association */

    Player p1 = new Player();  /* object of Player */

    Board boardClass = new Board(); /* object of boardclass */

    int tempi = 0;  /* i value holder. */
    int tempj = 0;  /*j value holder.  */

    JFrame baseFrame = new JFrame(); /* the main frame of our GUI */
    JPanel menu;  /* menu jpanel */
    JPanel lvls;  /* main game jpanel */
    JPanel helpFuncBtns; /* secondary jpanel in the lvls jpanel */
    JLabel score;  /* elements of helpfuncBtns Jpanel */
    JLabel remainTiles;  /* elements of helpfuncBtns Jpanel */


    /**
     *Constructor, sets the name of the window and starts the Menu
     */
    public GameForm()
    {
        baseFrame.setTitle("Simple Mahjong .");
        Menu();
    }


    private void Menu() {
        menu = new JPanel();  /* initialiazation */
        menu.setSize(600, 300);

        menu.add(Box.createVerticalStrut(200)); /*vertical structure, to handle the positioning of the elements in the frame */
        BoxLayout boxlayout = new BoxLayout(menu, BoxLayout.Y_AXIS); /* Set the Boxayout to be Y_AXIS from top to down */
        menu.setLayout(boxlayout);


        /**
         * Initiliazation fo jalbels,buttons, and other elements , defining of fonts and alignment between them & placing them in the corresponding panels.
         */
        JLabel name_lbl = new JLabel("Username");
        name_lbl.setFont(new Font("Tahoma",Font.BOLD,16));
        name_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(name_lbl);

        menu.add(Box.createVerticalStrut(10));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(100, 20));
        menu.add(nameField);

        menu.add(Box.createVerticalStrut(20));

        JRadioButton lvl_easy = new JRadioButton("EASY");
        lvl_easy.setFont(new Font("Tahoma",Font.BOLD,16));
        lvl_easy.setAlignmentX(Component.CENTER_ALIGNMENT);
        lvl_easy.setMargin(new Insets(0, 0, 0, 0));

        menu.add(lvl_easy);

        JRadioButton lvl_hard = new JRadioButton("HARD");
        lvl_hard.setAlignmentX(Component.CENTER_ALIGNMENT);
        lvl_hard.setFont(new Font("Tahoma",Font.BOLD,16));
        menu.add(lvl_hard);

        menu.add(Box.createVerticalStrut(20));

        JButton saveChoicesToFile = new JButton("Save Profile");
        saveChoicesToFile.setBorderPainted(false);
        saveChoicesToFile.setContentAreaFilled(false);
        saveChoicesToFile.setFont(new Font("Tahoma",Font.BOLD,16));
        saveChoicesToFile.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(saveChoicesToFile);

        menu.add(Box.createVerticalStrut(10));

        JButton playBtn = new JButton("Lets Play ");
        playBtn.setBorderPainted(false);
        playBtn.setContentAreaFilled(false);
        playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        playBtn.setFont(new Font("Tahoma",Font.BOLD,16));
        menu.add(playBtn);

        menu.add(Box.createVerticalStrut(10));

        JButton howtoBtn = new JButton("How to Play");
        howtoBtn.setBorderPainted(false);
        howtoBtn.setContentAreaFilled(false);
        howtoBtn.setFont(new Font("Tahoma",Font.BOLD,16));
        howtoBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        howtoBtn.setMargin(null);
        menu.add(howtoBtn);

        menu.add(Box.createVerticalStrut(10));

        JButton aboutBtn = new JButton("About");
        aboutBtn.setBorderPainted(false);
        aboutBtn.setContentAreaFilled(false);
        aboutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutBtn.setFont(new Font("Tahoma",Font.BOLD,16));

        menu.add(aboutBtn);
        menu.add(Box.createVerticalStrut(10));
        JButton exit = new JButton("Exit");
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setFont(new Font("Tahoma",Font.BOLD,16));

        menu.add(exit);
        menu.add(Box.createVerticalStrut(10));
        JLabel HOWTextField = new JLabel();
        HOWTextField.setSize(100, 100);
        HOWTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(HOWTextField);


        /**
         * defining action/mouse listeners to some of the menu buttons
         */
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Chiao"); System.exit(0); }
        });
        playBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Levels();}
        });

        howtoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { JOptionPane.showMessageDialog(null,from_file_to_label(HOWTextField, "howToBtnTextField.txt")); }
        });
        aboutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { JOptionPane.showMessageDialog(null,from_file_to_label(HOWTextField, "aboutBtnTextField.txt")); }
        });
        saveChoicesToFile.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e)
                                                {
                                                    Thread fileReadingThread = new Thread(() ->
                                                    {
                                                        from_gui_to_file(nameField,lvl_easy,lvl_hard);
                                                        JOptionPane.showMessageDialog(null,"Profile created Succesfully , check the txt.");
                                                    });
                                                    fileReadingThread.start();
                                                }
                                            });

        /**
         * setting menu panel to our main frame, setting size,visibility and repaint method.
         */
        baseFrame.setContentPane(menu);
        baseFrame.setSize(700, 700);
        baseFrame.validate();
        baseFrame.repaint();
        baseFrame.setVisible(true);
    }

    public void Levels()
    {

        baseFrame.setSize(1000, 1000);  /* redclearing the size of our main frame */
        helpFuncBtns = new JPanel();                /* initialiazation of the helpfuncbtns panel */
        lvls = new JPanel();                        /* initialiazation of the lvls panel */

        Box  b1 = Box.createVerticalBox();/* creating a b1 object of Box where we add the 2 jpanels lvls,helpFuncBtns for better handling the orientation of the elements */

        b1.add(helpFuncBtns);
        b1.add(lvls);

        /**
         * Setting gridbaglayout to the levels jpanel.
         */
        baseFrame.setLocationRelativeTo(null);
        GridBagLayout flo = new GridBagLayout();
        GridBagConstraints constrains = new GridBagConstraints();
        lvls.setLayout(flo);
        lvls.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        lvls.setBackground(Color.BLACK);

        /**
         * creating gui elements and placing them at the helpFuncBtns panel.
         */
         JLabel scorelbl = new JLabel("score :");
         helpFuncBtns.add(scorelbl);

         score = new JLabel("0");
         helpFuncBtns.add(score);

         JLabel remainTileslbl = new JLabel("Remaining Tiles :");
         helpFuncBtns.add(remainTileslbl);

         remainTiles = new JLabel("124");
         helpFuncBtns.add(remainTiles);

         JButton next_level = new JButton("Next Level.");
         next_level.setEnabled(false);
         helpFuncBtns.add(next_level);

        JButton show_nextMove = new JButton("Get a hint.");
        helpFuncBtns.add(show_nextMove);

        JButton undo = new JButton("UNDO");
        helpFuncBtns.add(undo);

        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for(Tiles c : tempMapToList)
                {
                    c.deleted = false;
                    Board.board.get(tempi).get(tempj).deleted = false;

                }
                System.out.println(undolistOfKeys.toString());
                undolistOfKeys.get(0).setVisible(true);
                undolistOfKeys.get(1).setVisible(true);
                undolistOfKeys.clear();
                System.out.println(undolistOfKeys);
            }
        });

        show_nextMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextMove();
                show_nextMove.setEnabled(false);

            }
        });
        next_level.addActionListener(new ActionListener() {   /* action listener for the nextlvl btns , recreating the lvl */
            @Override
            public void actionPerformed(ActionEvent e) {boardClass.nextlvl_shuffle(new Random(5)); Levels(); }
        });


        /**
         * iterating over the main board and creating btns for every tile.
         */
        for (int i = 0; i < Board.board.size(); i++)
        {
            for (int j = 0; j < Board.board.get(i).size(); j++)
            {
                this.tempi = i;
                this.tempj = j;
                JToggleButton Button = new JToggleButton("");           /* btn creation */
                buttonBoard.put(Button, Board.board.get(i).get(j));         /*inserting the btn with the according tile to the btnBoard */
                imgOfTilesPath = new ImageOfTiles();                        /*initialization of imagetilespath object */
                Button.addActionListener(this);                          /*adding the action listener (look below) to each btn */
                Button.setSelected(true);
                Button.setMargin(new Insets(0, 0, 0, 0));   /*fitting the btn border to the jpg of the Tile */

                /**
                 * For everyTile on the board find the respective imgTile (by checking specificTypeOfTile of each) and place it on the btns
                 */
                try {
                    if(Board.board.get(i).get(j).specificTypeOfTile != "o")  /*ignoring the "o" tiles , meaning the empty ones */
                    {
                        String s = imgOfTilesPath.iconToEachTile.get(Board.board.get(i).get(j).specificTypeOfTile);
                        Image img = ImageIO.read(getClass().getResource(s));
                        Image newimg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        Button.setIcon(new ImageIcon(newimg));
                    }
                } catch (Exception ex) { System.out.println(ex); }
                constrains.gridx = j;  /* the constrains of the gridbaglayout */
                constrains.gridy = i;
                if (buttonBoard.get(Button).specificTypeOfTile != "o")
                    lvls.add(Button, constrains);
            }
        }

      if(numFreeTiles==0)   /*if the user reached the end of the game, enable the btn to let him procced on the next one */
          next_level.setEnabled(true);

        lvls.validate();
        lvls.repaint();
        baseFrame.setVisible(true);
        baseFrame.setContentPane(b1);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("")) {
            {

                if (buttonBoard.get((JToggleButton) e.getSource()).isFree())             /*if btn is Free (see rules)..  */
                {
                    ((JToggleButton) e.getSource()).setBackground(Color.red);            /* since the btn is selected make the background of it red */

                    if (tempMap.size() < maxTempMapSize)                                 /*if the tempMap doesnt already hold a pair , place the first choice on it. */
                    {
                        tempMap.put((JToggleButton) e.getSource(), buttonBoard.get((JToggleButton) e.getSource()));         /*add the choice to the tempMap.*/
                        tempMapToList.add(buttonBoard.get((JToggleButton) e.getSource()));                                  /*add this choice to the list also. */
                    }

                    if (tempMap.size() == maxTempMapSize)                            /*if the choices tempMap already holds 1 pair (2 values).*/
                    {

                        /*check if this pair is valid with the rules of the game && make sure that the user CANNOT choose 2 times the same tile and delete it.  */
                        if (tempMapToList.get(0).isValidTiles(tempMapToList.get(1)) && tempMapToList.get(0) != tempMapToList.get(1)) {


                            /*find the respective keys of the values of the choices and save them to listOfKeysTodelete.*/
                            if (buttonBoard.containsValue(tempMapToList.get(0)) && buttonBoard.containsValue(tempMapToList.get(1)))
                            {
                                for (Map.Entry<JToggleButton, Tiles> entry : buttonBoard.entrySet())
                                {
                                    if (entry.getValue().equals(tempMapToList.get(0))) {
                                        listOfKeysToDelete.add(entry.getKey());
                                        undolistOfKeys.add(entry.getKey());
                                    }

                                    if (entry.getValue().equals(tempMapToList.get(1))) {
                                        listOfKeysToDelete.add(entry.getKey());
                                        undolistOfKeys.add(entry.getKey());
                                    }
                                }

                               if(tempMapToList.get(0).getGeneralTypeTile() ==  generalTypeTile.XARAKTIRON || tempMapToList.get(0).getGeneralTypeTile() == generalTypeTile.KIKLON || tempMapToList.get(0).getGeneralTypeTile() == generalTypeTile.MPAMPOU )
                               { p1.score = p1.score+ 20; }
                               else{ p1.score= p1.score+ 10; }

                               score.setText(Integer.toString(p1.score));   /*updating the score on the label on gui */
                                numFreeTiles -=2;
                               remainTiles.setText(Integer.toString(numFreeTiles));   /*updating the remaintiles on the label on gui */

                            }                                                /*updating the score on score.txt file */
                            try {
                                p1.score_to_file(p1.score);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                           /*since it was success update the original board since this is the one that (free and validTiles functions) "look up to".  */
                            Board.board.get(tempi).get(tempj).deleted = true;
                           // Board.board.get(tempi).get(tempj).deleted = true;

                            /*since it was success ,update these keys values from the btnMap and make them not visible to the GUI board.  */
                            buttonBoard.get(listOfKeysToDelete.get(0)).deleted = true;
                            buttonBoard.get(listOfKeysToDelete.get(1)).deleted = true;
                            listOfKeysToDelete.get(0).setVisible(false);
                            listOfKeysToDelete.get(1).setVisible(false);


                            /*clear the temp arrays & Maps so they can be ready to check the next pair of Tiles. */
                            tempMap.clear();
                            tempMapToList.clear();
                            listOfKeysToDelete.clear();

                        }
                        else /*if the pair is not valid , still clear the temp arrays and Maps so they can be ready to check the next pair of Tiles.*/
                        {
                            tempMap.clear();
                            tempMapToList.clear();
                            listOfKeysToDelete.clear();
                        }
                    }
                }

            }
        }
        baseFrame.revalidate();
    }


    public void nextMove()
    {
       for (Map.Entry<JToggleButton, Tiles> entry : buttonBoard.entrySet())
       {

           if (!entry.getValue().deleted && entry.getValue().specificTypeOfTile != "o")
           {
               if (entry.getValue().isFree())
               {
                   guessNextMovetempMap.put(entry.getKey(), entry.getValue());
                   guessNextMovetempMapToList.add(entry.getValue());
               }
           }

           System.out.println(guessNextMovetempMapToList.size());
           if (guessNextMovetempMapToList.size() == 2)
           {
               //System.out.println(guessNextMovetempMap);
               //System.out.println(guessNextMovetempMapToList.get(0));
               if (guessNextMovetempMapToList.get(0).isValidTiles(guessNextMovetempMapToList.get(1)))
               {

                   System.out.println(guessNextMovetempMapToList);
                 //  System.out.println(guessNextMovetempMapToList.get(1));

                   for (Map.Entry<JToggleButton, Tiles> mainposition : buttonBoard.entrySet())
                   {
                       for (Map.Entry<JToggleButton, Tiles> secondaryposition : guessNextMovetempMap.entrySet())
                       {
                           if (mainposition.getKey().equals(secondaryposition.getKey())) {
                               // the path must be relative to your *class* files


                               ImageIcon imgStream = new ImageIcon("bulb.jpg");
                               mainposition.getKey().setIcon(imgStream);

                           }
                       }
                   }
                   guessNextMovetempMap.clear();
                   guessNextMovetempMapToList.clear();
                   break;
               }
               guessNextMovetempMap.clear();
               guessNextMovetempMapToList.clear();

           }
       }
   }



    /**
     * @param textfield the textfiled on which we will output our message
     * @param filepath the path of the txtFile
     * @return sb , String builder which holds the text.
     */
    public StringBuilder from_file_to_label(JLabel textfield, String filepath)
    {

        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath), Charset.defaultCharset());
            for (String line : lines)
                sb.append(line + System.getProperty("line.separator"));


            return sb;
        } catch (IOException e1) { e1.printStackTrace(); }

        textfield.revalidate();
        return sb;
    }

    /**
     * @param namefield the namefield's text we want to capture
     * @param lvle the radio button we want to capture.
     * @param lvlh , the radio button we want to capture.
     * @return void , saving the info like (name,lvl) the user entered and saved them to the scores.txt file
     */
    public void from_gui_to_file(JTextField namefield,JRadioButton lvle,JRadioButton lvlh)
    {
        try {
            FileWriter fileWriter = new FileWriter("scores.txt", true);
            try (Writer writer = new BufferedWriter(fileWriter)) {
                String name = namefield.getText();
                p1.name = name;
                if (name.isEmpty()) { writer.write("guest"); }
                else { writer.write(name + " : "); }

                if (lvle.isSelected() || lvlh.isSelected())
                {
                    String lvl = lvle.getText();
                    writer.write(lvl);
                    p1.level = lvl;
                }
            } catch (IOException ex) { System.out.println("cannot open file to write score..."); }
        } catch (IOException e1) { e1.printStackTrace(); }
    }

    public static void undo() {
    }

    public void undoLastMove() {
    }

    public void giftNextMove() {
    }

    public void showMeNextMove() {
    }


}



