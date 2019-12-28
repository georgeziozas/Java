import javax.swing.JButton;

/**
 * Abstract class Tiles_Btn - contains the common fucntions of all the kind of tiles to be 
 * created in the game. 
 * Ex. ('Tetragono','Kiklos','Trigono','Romvos', 'OrthogParalilogramo','Joker').
 * Extends JButton Swing class for suitable functionality.
 * 
 * @author George Ziozas
 * @version 12/12/2019
 */
public abstract class Tiles_Btn extends JButton
{
    // instance variables
    private int coord_x; 
    private int coord_y;
    private String idShapeOnTile;
    
    /**
    * Abstract's class Tiles_Btn constructor.
    * @param coord_x : the 'x' position of Tile in the GameBoard.
    * @param coord_y : the 'y' position of Tile in the GameBoard.
    * @param idShape : the specific shape of the Tile ex. Kiklos,Romvos.
    * @return a new Tiles_Btn object with coord_x,coord_y and idShape.
    */
   public Tiles_Btn(int coord_x,int coord_y,String idShapeOnTile){
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.idShapeOnTile = idShapeOnTile;

    }
    
    /**
     * Responsible for drawing through graphics each shape on the Tiles.
     * Gets implemented from each class which extends Tiles_Btn.
     * @param The preferable style. 2 different drawings ("1","2").
     */
    abstract void drawShapeOnTile(String style);
    
    /**
     * Responsible for resseting the 'Tile' to its default drawing after the
     * user clicks on it.
     */
    protected void defaultDraw(){
    //TODO vres pws na kanei to koumpi reset se default btn view.
    };
    
    /** 
       * @return The 'x' coordinate in the game board grid.
       * 'protected' because only a subclass can implement them.
         */
    protected Integer getCoordX(){return this.coord_x;}
    
    /**
     * @param x : The x value you'd like to set in the x position of the tile in the game grid.
     * @return : sets the 'coord_x' to the corresponding 'x' value provided.
     * 'protected' because only a subclass can implement them.
       */
    protected void setCoordX(int x){this.coord_x =x;}
    
    /**
     * @return The 'y' coordinate in the game board grid. 
     * 'protected' because only a subclass can implement them.
       */
    protected Integer getCoordY(){return this.coord_y;}
    
    /**
     * @param y : The y value you'd like to set in the x position of the tile in the game grid.
     * @return : sets the 'coord_y' to the corresponding 'y' value provided.
     * 'protected' because only a subclass can implement them.
       */
    protected void setCoordY(int y){this.coord_y =y;}
    
    /**
     * @return The 'idShape' of the Tile 
     * 'protected' because only a subclass can implement them.
       */
    protected String getIdShape(){return this.idShapeOnTile;}
    
}
