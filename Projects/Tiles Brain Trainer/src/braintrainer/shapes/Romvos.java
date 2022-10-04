package braintrainer.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 * Write a description of class Romvos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Romvos extends Tiles_Btn {

    private Insets insets;

    /**
     * Constructor for objects of class Romvos
     *
     * @param index_flag
     * @param idShape
     */
    public Romvos(int index_flag, String idShape) {
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
        g2d.setColor(Color.BLACK);
        g2d.rotate(Math.toRadians(45));
        g2d.fillRect(((insets.left + insets.right) / 2) + 60, ((insets.top + insets.bottom) / 2) - 60, 60, 60);

    }

    /**
     *
     * @param g
     */
    @Override
    void shapeTwo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.rotate(Math.toRadians(45));
        g2d.fillRect(((insets.left + insets.right) / 2) + 60, ((insets.top + insets.bottom) / 2) - 60, 60, 60);

    }

    public long getUniqID() {
        return this.atomic_id;
    }
}
