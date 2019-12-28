package simplemahjong.Tiles;

import simplemahjong.Game.Board;
import simplemahjong.Game.generalTypeTile;

import java.util.List;
/**
 * @authors icsd15058 ZIOZAS GEORGIOS
 * icsd15213 CHALAGIANNIS XRISTOS
 */

/**
 * @desc Mpampou class extending Tiles class.
 */

public class Mpampou extends Tiles
{
    generalTypeTile generalTypeTile;   /* creates an enum generaTypeTile var. This var will hold the general name of the group which the Tile is in . */

    /**
     * Tiles, Constructor of the class.
     * Initializing the Tiles object , giving as parameters.
     *
     * @param specificTypeOfTile ex '1x'.
     * @param position           ex. new int[]{i, j} where i=row j=column
     */
    public Mpampou(String specificTypeOfTile, int[] position)
    {
        super(specificTypeOfTile, position);   /* calls the constructor of the super method which in this case is Tiles */
        this.generalTypeTile = getGeneralTypeTile();
    }

    /**
     * @return generalTyTile
     * @desc Gives the 'MPAMPOU' value to this tiles.generalTypeTile.
     */
    public generalTypeTile getGeneralTypeTile() {
        return simplemahjong.Game.generalTypeTile.MPAMPOU;
    }

    /**
     * imlements the abstract method.
     *
     * @param end,  The other tile the user has selected.
     *              return boolean - freeFlag.
     *              each class extending this abstract class implements its own version of isValidTiles.
     * @return -false if move is not valid.
     */
    @Override
    public boolean isValidTiles(Tiles end)
    {
        boolean validFlag = false;

        for (List l : Board.board) {
            if (this.getGeneralTypeTile().equals(end.getGeneralTypeTile()))  /*  //Checks if they are in the same category */
            {
                if (this.specificTypeOfTile.equals(end.specificTypeOfTile)) { validFlag = true; } /* checks if both Tiles has the same specificTypeOfTile name. ex '1x' , '1x'. */
            }
        }
        return validFlag;
    }
}
