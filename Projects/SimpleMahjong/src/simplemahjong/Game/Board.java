package simplemahjong.Game;

import simplemahjong.Tiles.*;

import java.util.*;

/**
 * @authors icsd15058 ZIOZAS GEORGIOS
 */

/**
 * Class description.
 *
 * @desc Creates the board of Tiles of our game and contains functions dealing
 * with initialization.
 */
public class Board {

    Random rand = new Random(20);

    /**
     * 1 final 1D Array of Strings (Strings containing all the specific type of
     * Tiles) (4 * mpampou , 4 *kiklon ...etc)
     */
    private final String[] tilesArray
            = {"1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "o", "o", "o",
                "1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "o", "o", "o",
                "1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "o", "o", "o",
                "1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "o", "o", "o",
                "1k", "2k", "3k", "4k", "5k", "6k", "7k", "8k", "9k", "o", "o", "o",
                "1k", "2k", "3k", "4k", "5k", "6k", "7k", "8k", "9k", "o", "o", "o",
                "1k", "2k", "3k", "4k", "5k", "6k", "7k", "8k", "9k", "o", "o", "o",
                "1k", "2k", "3k", "4k", "5k", "6k", "7k", "8k", "9k", "o", "o", "o",
                "1m", "2m", "3m", "4m", "5m", "6m", "7m", "8m", "9m", "o", "o", "o",
                "1m", "2m", "3m", "4m", "5m", "6m", "7m", "8m", "9m", "o", "o", "o",
                "1m", "2m", "3m", "4m", "5m", "6m", "7m", "8m", "9m", "o", "o", "o",
                "1m", "2m", "3m", "4m", "5m", "6m", "7m", "8m", "9m", "o", "o", "o",
                "1e", "2e", "3e", "4e", "o", "o", "o", "o", "o", "o", "o", "o",
                "1e", "2e", "3e", "4e", "o", "o", "o", "o", "o", "o", "o", "o",
                "1l", "2l", "3l", "4l", "o", "o", "o", "o", "o", "o", "o", "o",
                "1l", "2l", "3l", "4l", "o", "o", "o", "o", "o", "o", "o", "o"};

    private final int boardSize = 124;
    /*  The number of Tiles containted in the board. */
    public static List<List<Tiles>> board;
    /* A 2D list of Tiles (check Tiles Class for more) objects. Our main board. */
    public static List<String> tilesList;

    /* a list which will hold the 1d array , for easier manipulation. */


    /**
     * Board, Constructor of the class.
     */
    public Board() {
        BoardInitialiaztion();
    }

    /**
     * @return void - Optional sout at the end for testing.
     * @desc Initializes all the Tiles objects to the board array.
     */
    public void BoardInitialiaztion() {
        tilesList = new ArrayList<>();
        /* initializing the tileList list */
        tilesList.addAll(Arrays.asList(tilesArray));
        /* copies the 1d array to the list */
        Collections.shuffle(tilesList, rand);
        /* randomly shuffles the list */
        int ctr_listTiles = 0;
        /* Counter holding the tiles number that must be in the board , range of ctr_ListTiles ( 0 -124) */
        board = new ArrayList<>(boardSize);
        /*initializing the 2d board array (16rows*12columns) = 192. */


        for (int i = 0; i < 16; i++) {
            /* 1) iterating through the 2d creating a new list each time, 2)iterating each list of Lists , 3)scans the 1d list , 4) creates the apropriate Object Tile 5)all this untill we placed 192 Tiles in the board. */

            board.add(new ArrayList<>(12));

            for (int j = 0; j < 12; j++) {
                if (ctr_listTiles <= 192) {
                    if (tilesList.get(ctr_listTiles).contains("x")) {
                        board.get(i).add(new Xaraktiron(tilesList.get(ctr_listTiles), new int[]{i, j}));
                    } else if (tilesList.get(ctr_listTiles).contains("k")) {
                        board.get(i).add(new Kiklon(tilesList.get(ctr_listTiles), new int[]{i, j}));
                    } else if (tilesList.get(ctr_listTiles).contains("m")) {
                        board.get(i).add(new Mpampou(tilesList.get(ctr_listTiles), new int[]{i, j}));
                    } else if (tilesList.get(ctr_listTiles).contains("l")) {
                        board.get(i).add(new Louloudion(tilesList.get(ctr_listTiles), new int[]{i, j}));
                    } else if (tilesList.get(ctr_listTiles).contains("e")) {
                        board.get(i).add(new Epoxon(tilesList.get(ctr_listTiles), new int[]{i, j}));
                    } else if (tilesList.get(ctr_listTiles).contains("o")) {
                        board.get(i).add(new emptyBlock("o", new int[]{i, j}));
                    }
                }
                ctr_listTiles++;
            }
        }
    }

    public static List<List<Tiles>> getBoard() /* returns the board for printing */ {
        return board;
    }

    public void nextlvl_shuffle(Random rand) /* changes the level of the game by recreating the same board but with different orientation */ {
        Collections.shuffle(tilesList, rand);
        BoardInitialiaztion();
    }
}
