/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braintrainer.shapes;

/**
 *
 * @author User
 */
public interface Gameboard_Fuctions {
    public void GameLoop();
     public void gameBoardInit(String diffLvl);
     public void gameBoardFill();
      public void deleteTilesPair();
       public void resetDraw();
       public void initMilestoneLabels();
}
