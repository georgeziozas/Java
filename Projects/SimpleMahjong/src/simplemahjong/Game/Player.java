package simplemahjong.Game;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @authors icsd15058 ZIOZAS GEORGIOS
 * icsd15213 CHALAGIANNIS XRISTOS
 */

public class Player {



    public int score=0;
    public String name;    /*holds the name of the player. */
    public String level;   /*holds the desired level */


    public Player() {
        this.name = "empty";
        this.level = "not defined";
    }

    /**
     *Getters Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    /**
     *
      * @param score  the current score
     * @throws IOException
     * @returm void ,saves the current score to the scores.txt file.
     */
    public void score_to_file(int score) throws IOException {
        FileWriter fileWriter = new FileWriter("scores.txt", true);
        fileWriter.write(Integer.toString(score));
        fileWriter.write("\n");
        fileWriter.close();
    }
}
