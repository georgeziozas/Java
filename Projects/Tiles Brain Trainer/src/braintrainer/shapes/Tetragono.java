package braintrainer.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 * Write a description of class Tetragono here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tetragono extends Tiles_Btn {

    private Insets insets;

    /**
     * Constructor for objects of class Tetragono
     *
     * @param index_flag
     * @param idShape
     */
    public Tetragono(int index_flag, String idShape) {
        super(index_flag, idShape);
        insets = this.getInsets();

    }

    /**
     *
     * @param g
     */
    @Override
    void shapeOne(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.PINK);
        g2d.fillRect((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 60, 60);

    }

    /**
     *
     * @param g
     */
    @Override
    void shapeTwo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.yellow);
        g2d.fillRect((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 60, 60);

    }

    public long getUniqID() {
        return this.atomic_id;
    }
}
