import java.util.List ;
import java.util.ArrayList;
import java.util.Arrays; 
/**
 * Write a description of class GameBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameBoard
{

    // instance variables - replace the example below with your own
    public static GameBoard GameBoardInstance; //singleton
    private ArrayList<List<Tiles_Btn>> board;
    private int rows;
    private int cols;
    private List<Tiles_Btn> chosenPair; // List containing each time the pair the user chose on the GUI. size : 2.
    private int allowedTries; // The tries the user has (depending on the difficulty lvl chosen) before its GameOver.
    
    /**
     * Constructor for objects of class GameBoard
     */
    private GameBoard(){}
    
    
    /**
     * Initializes the 'GameBoard' according to the 'difficulty lvl' picked
     * by the user.
     * @param diffLvl : The difficulty user chose.
     */
     public void gameBoardInit(String diffLvl){
          
         switch(diffLvl) {
            case "EASY":
            case "easy":
                rows = 5; cols = 5;
                allowedTries = 8;
                break;
            case "MEDIUM":
            case "medium":
                rows = 8; cols = 8;
                allowedTries = 5;
                break;
            case "HARD":
            case "hard":
                rows = 10; cols = 10;
                allowedTries = 3;
                break;
            default:
                rows = 5; cols = 5;
                allowedTries = 8;
            
            board =  new ArrayList<List<Tiles_Btn>>(rows*cols); //board array initialization
            chosenPair = new ArrayList<Tiles_Btn>(2); //chosenPair array initialization
            for (int i = 0; i < rows; i++) {
                board.add(i,new ArrayList<Tiles_Btn>());
            }
        
         }
}

    /**
     * Fills the gameBoard with all the kind of Tiles('kiklos','Trigono' etc) available.
     */
    public void gameBoardFill(){
        
            List<String> flag =Arrays.asList("OrthogParalilogramo","Tetragono","Trigono","Kiklos","Romvos","Joker"); //List containing all the posible types of Tiles
            int ctr=-1; //keeping track of the index value of 'flag' array. Avoiding 'OutOfBound Exception'.
            
            //For every line in the GameBoard
            for(int i=0; i<rows; i++){
                ctr++;
                if(ctr == flag.size() - 1)
                    ctr=0;
                    
                    //Counter increments by 2 cause we need pairs of Tiles.
                    // "1" AND "2" is a reference to the kind of graphics to be drawn on the Tile, we have 2 different styles.
                    for(int j=0; j<cols; j+=2){ 
                 
                        if(flag.get(ctr).equals("OrthogParalilogramo")){
                            board.get(i).add(j,new OrthogParalilogramo(i,j,"1"));
                            board.get(i).add(j+1,new OrthogParalilogramo(i,j+1,"2"));
                        }else if(flag.get(ctr).equals("Tetragono")){
                            board.get(i).add(j,new Tetragono(i,j,"1"));
                            board.get(i).add(j+1,new Tetragono(i,j+1,"2"));
                        }if(flag.get(ctr).equals("Trigono")){
                            board.get(i).add(j,new Trigono(i,j,"1"));
                            board.get(i).add(j+1,new Trigono(i,j+1,"2"));
                        }if(flag.get(ctr).equals("Kiklos")){
                            board.get(i).add(j,new Kiklos(i,j,"1"));
                            board.get(i).add(j+1,new Kiklos(i,j+1,"2"));
                        }if(flag.get(ctr).equals("Romvos")){
                            board.get(i).add(j,new Romvos(i,j,"1"));
                            board.get(i).add(j+1,new Romvos(i,j+1,"2"));
                        }if(flag.get(ctr).equals("Joker")){
                            board.get(i).add(j,new Joker(i,j,"1"));
                            board.get(i).add(j+1,new Joker(i,j+1,"2"));
                        }else{
                            System.out.println("Error filling all cells");
                        }
                    }
            }
    }
    
    /**
     * @return True if the 2 chosen Tiles makes a pair , False otherwise.
     */
    public boolean isValidPair(){
        if(chosenPair.get(0).getClass().getName() == chosenPair.get(1).getClass().getName())
            return true;
        return false;
    }
    
    /**
     * Deletes the clicked tiles from the board.
     */
    public void deleteTilesPair(){
        board.remove(chosenPair.get(0));
        board.remove(chosenPair.get(1));
        chosenPair.clear();
        
    }
    
    /**
     * Main Game Loop.
     */
    public void PlayGame(){}
    
    /**
     * Lazy Initialization - Making sure we can create 1 and only 1 GameBoard 
     * class instance , So every move the player makes is beign done in the 
     * same 'GameBoard' instance instead of creating a new one each time. */
    public static GameBoard getInstance(){
        if(GameBoardInstance == null){
             GameBoardInstance = new GameBoard();
        }
        return GameBoardInstance;
    }
}


/* OLA AUTA MESA STA GUI MANAGE
    public void PauseGame(){}
    public void ExitGame(){}
    public void ShowLeaderboard(){}
    */
   
       /*public enum Level {
   EASY("EASY"), MEDIUM("MEDIUM") , HARD("HARD");
   private final String lvlValue;
   Level(final String s) { lvlValue = s; }
   public String getName() { return lvlValue; }
   // further methods, attributes, etc.
}*/
