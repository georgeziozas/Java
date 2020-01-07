package memorymastergame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 * Write a description of class OrthogParalilogramo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrthogParalilogramo extends Tiles_Btn {

    private Insets insets;

    /**
     * Constructor for objects of class OrthogParalilogramo
     *
     * @param coord_x
     * @param coord_y
     * @param idShape
     */
    public OrthogParalilogramo(int coord_x, int coord_y, String idShape) {
        super(coord_x, coord_y, idShape);
        insets = this.getInsets();
    }

    /**
     *
     * @param g
     */
    @Override
    void shapeOne(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.orange);
        g2d.fillRect((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 90, 50);

    }

    /**
     *
     * @param g
     */
    @Override
    void shapeTwo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 90, 50);

    }

    public long getUniqID() {
        return this.atomic_id;
    }
}
