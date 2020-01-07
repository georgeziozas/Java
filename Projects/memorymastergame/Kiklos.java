package memorymastergame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 * Write a description of class Kiklos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Kiklos extends Tiles_Btn {

    private Insets insets;

    /**
     * Constructor for objects of class Kiklos
     *
     * @param coord_x
     * @param coord_y
     * @param idShapeOnTile
     */
    public Kiklos(int coord_x, int coord_y, String idShapeOnTile) {
        super(coord_x, coord_y, idShapeOnTile);
        insets = this.getInsets();
    }

    /**
     *
     * @param g
     */
    @Override
    void shapeOne(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillOval((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 60, 60);
    }

    /**
     *
     * @param g
     */
    @Override
    void shapeTwo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);
        g2d.fillOval((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 60, 60);
    }

    public long getUniqID() {
        return this.atomic_id;
    }
}
