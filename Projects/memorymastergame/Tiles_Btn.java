package memorymastergame;

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
 * @author George Ziozas
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
    private int coord_x;
    private int coord_y;
    private final String idShapeOnTile;

    /**
     * Abstract's class Tiles_Btn constructor.
     *
     * @param coord_x : the 'x' position of Tile in the GameBoard.
     * @param coord_y : the 'y' position of Tile in the GameBoard.
     * @param idShapeOnTile : the specific shape of the Tile ex. Kiklos,Romvos.
     * @return a new Tiles_Btn object with coord_x,coord_y and idShape.
     */
    public Tiles_Btn(int coord_x, int coord_y, String idShapeOnTile) {
        this.atomic_id = UNIQ_ID.getAndIncrement();
        this.coord_x = coord_x;
        this.coord_y = coord_y;
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
        GameBoard.clickedTilesCtr++; //incrementing the num of Btn_Tiles clicked on the board

        GameBoard.GameBoardInstance.chosenPair.add(GameBoard.indexToAdd, this); //adds the clicked tile to the 'chosenPair' list.
        GameBoard.indexToAdd++; // incrementing the index variable of 'chosenPair' list.

        GameBoard.GameBoardInstance.GameLoop(); //Game Loop
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
    protected Integer getCoordX() {
        return this.coord_x;
    }

    /**
     * @param x : The x value you'd like to set in the x position of the tile in
     * the game grid. sets the 'coord_x' to the corresponding 'x' value
     * provided. 'protected' because only a subclass can implement them.
     */
    protected void setCoordX(int x) {
        this.coord_x = x;
    }

    /**
     * @return The 'y' coordinate in the game board grid. 'protected' because
     * only a subclass can implement them.
     */
    protected Integer getCoordY() {
        return this.coord_y;
    }

    /**
     * @param y : The y value you'd like to set in the x position of the tile in
     * the game grid. sets the 'coord_y' to the corresponding 'y' value
     * provided. 'protected' because only a subclass can implement them.
     */
    protected void setCoordY(int y) {
        this.coord_y = y;
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
