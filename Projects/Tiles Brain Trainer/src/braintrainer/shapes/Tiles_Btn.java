package braintrainer.shapes;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Abstract class Tiles_Btn - contains the common fucntions of all the kind of
 * tiles to be created in the game. Ex.
 * ('Tetragono','Kiklos','Trigono','Romvos', 'OrthogParalilogramo','Joker').
 * Extends JButton Swing class for suitable functionality.
 *
 * @author Grammatikas Thanasis
 * @version 12/12/2019
 */
public abstract class Tiles_Btn extends JButton implements ActionListener {

    // instance variables
    static final AtomicLong UNIQ_ID = new AtomicLong(0);

    /**
     *
     */
    public long atomic_id;
    private boolean actionFlag; // if actionPerformed is triggered action flag equals true , otherwise is set to false
    private int index_flag;
    private final String idShapeOnTile;

    /**
     * Abstract's class Tiles_Btn constructor.
     *
     * @param index_flag
     * @param idShapeOnTile : the specific shape of the Tile ex. Kiklos,Romvos.
     */
    public Tiles_Btn(int index_flag, String idShapeOnTile) {
        this.atomic_id = UNIQ_ID.getAndIncrement();
        this.index_flag = index_flag;
        this.idShapeOnTile = idShapeOnTile;
        this.actionFlag = false;
        addActionListener(this);

    }

    /**
     * Responsible for drawing through graphics each shape on the Tiles. Gets
     * implemented from each class which extends Tiles_Btn. Each type of BTN has
     * 2 different drawing of the same shape. ex. Circle BTN has 2 different
     * available drawings both drawings contain a circle but in different
     * 'style'.
     *
     * @param style The preferable style. 2 different drawings ("1","2").
     * @param g
     */
    protected void drawShapeOnTile(String style, Graphics g) {
        if (style.equals("1")) {
            shapeOne(g);
        } else if (style.equals("2")) {
            shapeTwo(g);
        }
    }

    /**
     * 'shapeOne' describes the first style.
     *
     * @param style
     * @param g
     */
    abstract void shapeOne(Graphics g);

    /**
     * 'shapeTwo' describes the second style.
     *
     * @param style
     * @param g
     */
    abstract void shapeTwo(Graphics g);

    /**
     * Responsible for resseting the 'Tile' to its default drawing after the
     * user clicks on it or when the user hasnt clicked the button yet.
     *
     * @param g
     */
    protected void defaultDraw(Graphics g) {
        this.setBackground(new Color(51, 204, 255));
    }

    /**
     *
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.actionFlag = true;
        Gameboard.clickedTilesCtr++; //incrementing the num of Btn_Tiles clicked on the board

        Gameboard.GameBoardInstance.chosenPair.add(Gameboard.indexToAdd, this); //adds the clicked tile to the 'chosenPair' list.
        Gameboard.indexToAdd++; // incrementing the index variable of 'chosenPair' list.

        Gameboard.GameBoardInstance.GameLoop(); //Game Loop
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.actionFlag == false) {
            defaultDraw(g);
        } else if (this.actionFlag == true) {
            this.setBackground(new Color(224, 224, 224));
            drawShapeOnTile(getIdShape(), g);
        }
        revalidate();
        repaint();
    }

    /**
     * GETTERS / SETTERS
     */
    /**
     * @param actionFlag
     */
    protected void setActionFlag(boolean actionFlag) {
        this.actionFlag = actionFlag;
    }

    /**
     * @return The 'x' coordinate in the game board grid. 'protected' because
     * only a subclass can implement them.
     */
    protected Integer getIndexFlag() {
        return this.index_flag;
    }

    /**
     * 'protected' because only a subclass can implement them.
     *
     * @return The 'idShape' of the Tile.
     */
    protected String getIdShape() {
        return this.idShapeOnTile;
    }

}

