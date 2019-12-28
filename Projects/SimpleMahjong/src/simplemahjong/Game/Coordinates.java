package simplemahjong.Game;
/**
 * @authors icsd15058 ZIOZAS GEORGIOS
 * icsd15213 CHALAGIANNIS XRISTOS
 */

/**
 * Class description.
 *
 * @desc class of Coordinates, this class is used to create a x,y pair of ints,giving the ability to set them also.
 */
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        setPosition(x, y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *getters
     */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

