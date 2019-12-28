package simplemahjong.Tiles;

import simplemahjong.Game.generalTypeTile;

public class emptyBlock extends Tiles {

    /**
     * empty block, Constructor of the class.
     * Initializing the Tiles object , giving as parameters.
     *
     * @param specificTypeOfTile ex '1x'.
     * @param position           ex. new int[]{i, j} where i=row j=column in the board array
     * We just add "o" as specificTypeOfTile and we ignore it , we use emptyBlock class as an emptyObject.
     */
    public emptyBlock(String specificTypeOfTile, int[] position) {
        super(specificTypeOfTile, position);

    }
    @Override
    public boolean isValidTiles(Tiles end) {
        return false;
    }

    @Override
    public generalTypeTile getGeneralTypeTile() {
        return generalTypeTile.EMPTY;
    }
}
