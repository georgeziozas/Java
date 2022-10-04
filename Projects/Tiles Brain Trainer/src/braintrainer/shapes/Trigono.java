package braintrainer.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Polygon;

/**
 * Write a description of class Trigono here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trigono extends Tiles_Btn {

    private Insets insets;

    /**
     * Constructor for objects of class Trigono
     *
     * @param index_flag
     * @param idShape
     */
    public Trigono(int index_flag, String idShape) {
        super(index_flag, idShape);
        insets = this.getInsets();
    }

    /**
     *
     * @param g
     */
    @Override
    void shapeOne(Graphics g) {
        Polygon Poly1 = new Polygon(new int[]{10, 200, 10}, new int[]{10, 200, 400}, 3);
        g.setColor(Color.red);
        g.fillPolygon(Poly1);

    }

    /**
     *
     * @param g
     */
    @Override
    void shapeTwo(Graphics g) {
        Polygon Poly1 = new Polygon(new int[]{10, 200, 10}, new int[]{10, 200, 400}, 3);
        g.setColor(Color.black);
        g.fillPolygon(Poly1);
    }

    public long getUniqID() {
        return this.atomic_id;
    }

}
