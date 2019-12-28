package simplemahjong.Tiles;


import simplemahjong.Game.Board;
import simplemahjong.Game.generalTypeTile;

import java.util.List;
/**
 * @authors icsd15058 ZIOZAS GEORGIOS
 * icsd15213 CHALAGIANNIS XRISTOS
 */

/**
 * @desc Louloudion class extending Tiles class.
 */
public class Louloudion extends Tiles
{
    generalTypeTile generalTypeTile;  /*creates an enum generaTypeTile var. This var will hold the general name of the group which the Tile is in .  */

    /**
     * Louloudion, Constructor of the class.
     * Initializing the Louloudion object , giving as parameters.
     *
     * @param specificTypeOfTile ex '1x'.
     * @param position           ex. new int[]{i, j} where i=row j=column
     */
    public Louloudion(String specificTypeOfTile, int[] position)
    {
        super(specificTypeOfTile, position);    /* calls the constructor of the super method which in this case is Tile */
        this.generalTypeTile = getGeneralTypeTile();
    }

    /**
     * @return generalTyTile
     * @desc Gives the 'Louloudion' value to this tiles.generalTypeTile.
     */
    public generalTypeTile getGeneralTypeTile() {
        return simplemahjong.Game.generalTypeTile.LOYLOYDION;
    }

    /**
     * imlements the abstract method.
     *
     * @param end,  The other tile the user has selected.
     *              return boolean - freeFlag.
     *              each class extending this abstract class implements its own version of isValidTiles.
     * @return True if move is valid , False otherwise.
     */
    @Override
    public boolean isValidTiles(Tiles end)
    {
        boolean validFlag = false;
        for (List l : Board.board)
        {
            if (getGeneralTypeTile().equals(end.getGeneralTypeTile()))  /*Checks if they are in the same category*/
                validFlag = true;
            else
                validFlag = end.getGeneralTypeTile().equals(simplemahjong.Game.generalTypeTile.EPOXON);  /* Checks if the other Tile is in the Louloudion Category, cause in the game epoxes and louloudia can be combined */
        }
        return validFlag;
    }
}


