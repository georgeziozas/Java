package simplemahjong.Tiles;
import simplemahjong.Game.Board;
import simplemahjong.Game.Coordinates;
import simplemahjong.Game.generalTypeTile;
import java.util.List;
/**
 * * @authors
 * icsd15058 ZIOZAS GEORGIOS
 * icsd15213 CHALAGIANNIS XRISTOS
 */


/**
 * Class description.
 *
 * @desc Abstract class of Tiles , This class creates the Tiles object which contains all the information about the Tile.
 * Also contains functions for checking if the Tile is eligable to move following the rules of the game.  (isFree).
 * An abstract isValid function.
 * An override of ToString Method.
 * A getter of generalTypeOfTile.
 */
public abstract class Tiles
{

    public Coordinates position;          /* Coordinates objects hold the ('i'=line position and 'j'=column position) of the cell which the object is in. */
    public String specificTypeOfTile;     /*holds a string with the representative nickname of each tile ex. The 'Xaraktiron Tiles' has 9 type of tiles : '1x','2x'..etc. Thats the value we hold here. */
    public boolean deleted = false;       /* If the Tile has been deleted.

    /**
     * Tiles, Constructor of the class.
     * Initializing the Tiles object , giving as parameters.
     *
     * @param specificTypeOfTile ex '1x'.
     * @param position           ex. new int[]{i, j} where i=row j=column in the board array

     */
    public Tiles(String specificTypeOfTile, int[] position)
    {
        this.specificTypeOfTile = specificTypeOfTile;
        this.position = new Coordinates(position[0], position[1]);
    }
    /**
     * @return - True if isFree , False otherwise.
     */
    public boolean isFree()
    {
        boolean freeFlag = false;

        for (List l : Board.board)
        {

            if (position.getY() == 0 || position.getY() == l.size() - 1)   /* //if is in the first position of the line or in the last. Cause in this case its always free. */
            {
                freeFlag = true;
                break;
            }
            else if (Board.board.get(position.getX()).get(position.getY() - 1).deleted || Board.board.get(position.getX()).get(position.getY() + 1).deleted ||
                    Board.board.get(position.getX()).get(position.getY() - 1).specificTypeOfTile == "o" || Board.board.get(position.getX()).get(position.getY() + 1).specificTypeOfTile == "o"   )   /* otherwise check at the tile's left and right and check if at least 1 of these directions doesnt have a neighbour. */
            {
                    freeFlag = true;
                    break;
            }
            else { break; }
        }
        return freeFlag;
    }
    /**
     * @param end,  The other tile the user has selected.
     *              return boolean - freeFlag.
     *              each class extending this abstract class implements its own version of isValidTiles.
     * @desc abstract method, returns true if this.Tile and another one which the user selected are valid to choose given the rules of the game.
     */
    public abstract boolean isValidTiles(Tiles end);

    /**
     * overidding toString method of Tiles mainly for testing purposes.
     *
     * @return Strings of position x,y of Tile.
     */
    @Override
    public String toString()
    {
        return getGeneralTypeTile() + " " + position.getX() + "--" + position.getY() ;
    }
    /**
     * @return generalTypeTile enum (see class generalTypeTile for more info).
     * @desc each Tile has a generaltype of tile ex Kiklon,Xaraktiron. and this method gives the choice to group a tile in a specific group of Tiles.
     */
    public abstract generalTypeTile getGeneralTypeTile();
}

