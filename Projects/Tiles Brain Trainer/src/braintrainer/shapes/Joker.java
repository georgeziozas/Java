package braintrainer.shapes;
import braintrainer.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 * Write a description of class Joker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Joker extends Tiles_Btn {

    private Insets insets;

    /**
     * Constructor for objects of class Joker
     *
     * @param index_flag
     * @param idShape
     */
    public Joker(int index_flag, String idShape) {
        super(index_flag, idShape);
        insets = this.getInsets();
    }

    /**
     *
     * @param g
     */
    @Override
    void shapeOne(Graphics g) {
        String str = "JOKER";
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.green);
        g2d.drawOval((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 80, 80);

        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 20));
        g2d.setColor(Color.ORANGE);
        g2d.drawString(str, (insets.left + insets.right) / 2, ((insets.top + insets.bottom) / 2) + 30);
    }

    /**
     *
     * @param g
     */
    @Override
    void shapeTwo(Graphics g) {
        String str = "JOKER";
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.green);
        g2d.drawOval((insets.left + insets.right) / 2, (insets.top + insets.bottom) / 2, 80, 80);

        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 20));
        g2d.setColor(Color.ORANGE);
        g2d.drawString(str, (insets.left + insets.right) / 2, ((insets.top + insets.bottom) / 2) + 30);
    }

}

