package memorymastergame;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class GameBoard {

    // instance variables - replace the example below with your own
    public static GameBoard GameBoardInstance; //singleton
    Timer deleteTimer, resetTimer;
    private ArrayList<List<Tiles_Btn>> board;

    private int rows;
    private int cols;
    private int allowedTries; // The tries the user has (depending on the difficulty lvl chosen) before its GameOver.
    private int tilesLeft;

    public List<Tiles_Btn> chosenPair; // list containing the array 'chosenPair' so i can use enhanced funcs of list but still hold fixed size.
    public static int clickedTilesCtr; // counter keeping track of how many btns has been clicked on the board
    public static int indexToAdd; // int pointing the exact index on which the btn gonna be placed at chosenPair list. ( 0 or 1 )
    Random rnd = new Random(10);
    /**
     * Constructor for objects of class GameBoard
     */
    private GameBoard() {

    }

    /**
     * Game Loop.
     */
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
                    GameBoard.indexToAdd = 0; //resseting the index flag.
                    GameBoard.clickedTilesCtr = 0; //ressetung the ctr.
                }
            }
        }
    }

    /**
     * Initializes the 'GameBoard' according to the 'difficulty lvl' picked by
     * the user.
     *
     * @param diffLvl : The difficulty user chose.
     */
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
                allowedTries = 5;
                tilesLeft = 64;
                break;
            case "HARD":
            case "hard":
                rows = 10;
                cols = 10;
                allowedTries = 3;
                tilesLeft = 100;
                break;
            default:
                rows = 5;
                cols = 5;
                allowedTries = 8;
                tilesLeft = 25;
        }
        board = new ArrayList<>(rows * cols); //board array initialization
        chosenPair = new ArrayList<>(2);//chosenPair array initialization

        clickedTilesCtr = 0;
        indexToAdd = 0;

        for (int i = 0; i < rows; i++) {
            board.add(i, new ArrayList<>());
        }

    }

    /**
     * Fills the gameBoard with all the kind of Tiles('kiklos','Trigono' etc)
     * available.
     */
    public void gameBoardFill() {

        List<String> flag = Arrays.asList("OrthogParalilogramo", "Tetragono", "Trigono", "Kiklos", "Romvos", "Joker"); //List containing all the posible types of Tiles
        int ctr = -1; //keeping track of the index value of 'flag' array. Avoiding 'OutOfBound Exception'.

        //For every line in the GameBoard
        for (int i = 0; i < rows; i++) {

            /**
             * Counter increments by 2 cause we need pairs of Tiles. "1" AND "2"
             * is a reference to the kind of graphics to be drawn on the Tile,
             * we have 2 different styles.
             */
            for (int j = 0; j < cols; j += 2) {
                ctr++;

                switch (flag.get(ctr)) {
                    case "OrthogParalilogramo":
                        board.get(i).add(j, new OrthogParalilogramo(i, j, "1"));
                        board.get(i).add(j + 1, new OrthogParalilogramo(i, j + 1, "2"));
                        break;
                    case "Tetragono":
                        board.get(i).add(j, new Tetragono(i, j, "1"));
                        board.get(i).add(j + 1, new Tetragono(i, j + 1, "2"));
                        break;
                    case "Trigono":
                        board.get(i).add(j, new Trigono(i, j, "1"));
                        board.get(i).add(j + 1, new Trigono(i, j + 1, "2"));
                        break;
                    case "Kiklos":
                        board.get(i).add(j, new Kiklos(i, j, "1"));
                        board.get(i).add(j + 1, new Kiklos(i, j + 1, "2"));
                        break;
                    case "Romvos":
                        board.get(i).add(j, new Romvos(i, j, "1"));
                        board.get(i).add(j + 1, new Romvos(i, j + 1, "2"));
                        break;
                    case "Joker":
                        board.get(i).add(j, new Joker(i, j, "1"));
                        board.get(i).add(j + 1, new Joker(i, j + 1, "2"));
                        break;
                    default:
                        System.out.println("Error filling all cells");
                        break;
                }

                if (ctr == flag.size() - 1) { //keeps the ctr in the proper limits so we dont get nullException
                    ctr = 0;
                }

            }
        }
        Collections.shuffle(board, rnd); //shuffling the board elements before adding them to the GameWindow
        
        
        /**
         * Traversing the board and adding all the elements inside the Jpanel.
         */
        int ctr1 = -1; //keeping track of the index value of 'flag' array. Avoiding 'OutOfBound Exception'.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j += 2) {
                ctr1++;
                GameWindow.mainPanel.add(board.get(i).get(j)); // adding the buttons to Jpanel of GameWindow
                GameWindow.mainPanel.add(board.get(i).get(j + 1));
                GameWindow.mainPanel.revalidate();
                GameWindow.mainPanel.repaint();

                if (ctr1 == flag.size() - 1) { //keeps the ctr in the proper limits so we dont get nullException
                    ctr1 = 0;
                }
            }
        }
    }

    /**
     * @return True if the 2 chosen Tiles makes a pair , False otherwise.
     */
    public boolean isValidPair() {
        if (chosenPair.get(0).getClass().getName().equals(chosenPair.get(1).getClass().getName())) {
            if (chosenPair.get(0).atomic_id != chosenPair.get(1).atomic_id) {
                tilesLeft -= 2;
                GameWindow.tilesLeftLbl.setText("Tiles Remaining : " + String.valueOf(tilesLeft));
                return true;
            }
        }
        allowedTries--;
        GameWindow.triesLeftLbl.setText("Tries Remaining : " + String.valueOf(allowedTries));
        return false;
    }

    /**
     * Deletes the clicked tiles from the board.
     */
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

    public void resetDraw() {

        resetTimer = new Timer(800, (ActionEvent ae) -> {
            chosenPair.get(0).setActionFlag(false);
            chosenPair.get(1).setActionFlag(false);
        });
        resetTimer.setRepeats(false);
        resetTimer.start();

    }

    /**
     * Lazy Initialization - Making sure we can create 1 and only 1 GameBoard
     * class instance , So every move the player makes is beign done in the same
     * 'GameBoard' instance instead of creating a new one each time.
     *
     * @return
     */
    public static GameBoard getInstance() {
        if (GameBoardInstance == null) {
            GameBoardInstance = new GameBoard();
        }
        return GameBoardInstance;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public ArrayList<List<Tiles_Btn>> getGameBoard() {
        return this.board;
    }

    public void initMilestoneLabels() {
        GameWindow.tilesLeftLbl.setText("Tiles Remaining : " + String.valueOf(tilesLeft)); //initializing gameWindow labels
        GameWindow.triesLeftLbl.setText("Tries Remaining : " + String.valueOf(allowedTries));
    }
}
