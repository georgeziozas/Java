package braintrainer.shapes;

import braintrainer.gui.Gameboard_GUI;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Gameboard implements Gameboard_Fuctions {

    // instance variables - replace the example below with your own
    ShapesFactory SF;
    public static Gameboard GameBoardInstance=null; //singleton
    Timer deleteTimer, resetTimer;
    public List<Tiles_Btn> board; // list containing all the buttons which represent the game Tiles.
    public List<Tiles_Btn> chosenPair; // list containing the array 'chosenPair' so i can use enhanced funcs of list but still hold fixed size.
    private int num_typeOfTiles;
    public int rows;
    public int cols;
    private int allowedTries; // The tries the user has (depending on the difficulty lvl chosen) before its GameOver.
    private int tilesLeft;
  
    public static int clickedTilesCtr; // counter keeping track of how many btns has been clicked on the board
    public static int indexToAdd; // int pointing the exact index on which the btn gonna be placed at chosenPair list. ( 0 or 1 )
    Random rnd = new Random(10);
    /**
     * Constructor for objects of class GameBoard
     */
    private Gameboard() {
        SF = new ShapesFactory();
    }

    /**
     * Game Loop.
     */
    @Override
    public void GameLoop() {

       
        if (this.tilesLeft != 0) {
            if (this.allowedTries != 0) {
                if (clickedTilesCtr == 2) {
                    if (isValidPair()) {
                        deleteTilesPair();
                        if (this.tilesLeft == 0) {
                            String gameOverMessage = "YOU WON ! YOU ARE A BEAST ! \n NOW its time to try in a different difficulty dont you think?";
                            JOptionPane.showMessageDialog(null, gameOverMessage, "GAMEOVER", JOptionPane.OK_OPTION);
                            System.exit(0);
                        }
                    } else if (!isValidPair()) {
                        resetDraw();
                        if (this.allowedTries == 0) {
                            String gameOverMessage = "GAME OVER - YOUR TRIES REACHED ZERO. \n now the game will exit \n if you dare , try again!.";
                            JOptionPane.showMessageDialog(null, gameOverMessage, "GAMEOVER", JOptionPane.OK_OPTION);
                            System.exit(0);
                        }
                    }
                    Gameboard.indexToAdd = 0; //resseting the index flag.
                    Gameboard.clickedTilesCtr = 0; //ressetung the ctr.
                }
            }
        }
    }

    /**
     * Initializes the 'Gameboard' according to the 'difficulty lvl' picked by
 the user.
     *
     * @param diffLvl : The difficulty user chose.
     */
    @Override
    public void gameBoardInit(String diffLvl) {

        switch (diffLvl) {
            case "EASY":
            case "easy":
                this.rows = 6;
                this.cols = 6;
                allowedTries = 8;
                tilesLeft = 36;
                break;
            case "MEDIUM":
            case "medium":
                rows = 8;
                cols = 8;
                allowedTries = 6;
                tilesLeft = 64;
                break;
            case "HARD":
            case "hard":
                rows = 10;
                cols = 10;
                allowedTries = 4;
                tilesLeft = 100;
                break;
            default:
                rows = 6;
                cols = 6;
                allowedTries = 8;
                tilesLeft = 36;
        }
        board = new ArrayList<>(rows * cols); //board array initialization
        chosenPair = new ArrayList<>(2);//chosenPair array initialization

        clickedTilesCtr = 0;
        num_typeOfTiles = 6;

    }

    /**
     * Fills the gameBoard with all the kind of Tiles('kiklos','Trigono' etc)
     * available.
     */
    @Override
    public void gameBoardFill() {

        int random_num_max = num_typeOfTiles - 1;
        int random_number_min = 0;
        int index_flag = 0;
        for (int i= 0; i < rows*cols; i+=2) {
                int randomNum = rnd.nextInt((random_num_max - random_number_min) + 1) + random_number_min; //0-5               
                board.add(SF.getShape(index_flag, SF.tipoi_sximaton.get(randomNum),"1"));
                board.add(SF.getShape(index_flag + 1, SF.tipoi_sximaton.get(randomNum),"2"));
                index_flag += 2;
            
        }
                Collections.shuffle(board, rnd); //shuffling the board elements before adding them to the Gameboard_GUI
}

    /**
     * @return True if the 2 chosen Tiles makes a pair , False otherwise.
     */
    public boolean isValidPair() {
        if (chosenPair.get(0).getClass().getName().equals(chosenPair.get(1).getClass().getName())) {
            if (chosenPair.get(0).atomic_id != chosenPair.get(1).atomic_id) {
                tilesLeft -= 2;
                Gameboard_GUI.tilesLeftLbl.setText("Tiles Remaining : " + String.valueOf(tilesLeft));
                return true;
            }
        }
        allowedTries--;
        Gameboard_GUI.triesLeftLbl.setText("Tries Remaining : " + String.valueOf(allowedTries));
        return false;
    }

    /**
     * Deletes the clicked tiles from the board.
     */
    @Override
    public void deleteTilesPair() {
        deleteTimer = new Timer(800, (ActionEvent ae) -> {
            chosenPair.get(0).setVisible(false);
            chosenPair.get(1).setVisible(false);
        });
        deleteTimer.setRepeats(false);
        deleteTimer.start();

        board.remove(chosenPair.get(0));
        board.remove(chosenPair.get(1));
    }

    @Override
    public void resetDraw() {

        resetTimer = new Timer(800, (ActionEvent ae) -> {
            chosenPair.get(0).setActionFlag(false);
            chosenPair.get(1).setActionFlag(false);
        });
        resetTimer.setRepeats(false);
        resetTimer.start();

    }

    /**
     * Lazy Initialization - Making sure we can create 1 and only 1 Gameboard
 class instance , So every move the player makes is beign done in the same
 'Gameboard' instance instead of creating a new one each time.
     *
     * @return
     */
    public static Gameboard getInstance() {
        if (GameBoardInstance == null) {
            GameBoardInstance = new Gameboard();
        }
        return GameBoardInstance;
    }

    public static void setInstance() {
        GameBoardInstance = null;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    /**
     * Initializing the milestone's label's (TilesLeft & TriesLeft)
     */
    @Override
    public void initMilestoneLabels() {
        Gameboard_GUI.tilesLeftLbl.setText("Tiles Remaining : " + String.valueOf(tilesLeft)); //initializing gameWindow labels
        Gameboard_GUI.triesLeftLbl.setText("Tries Remaining : " + String.valueOf(allowedTries));
    }
}
