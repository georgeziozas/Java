package simplemahjong.GUI;

import java.util.HashMap;

/** class desc
 * @desc Maps each specificType of Tile string to an image path at hard drive.
 */
public class ImageOfTiles {
    int MAXELEMENTS = 35;
    public final HashMap<String,String> iconToEachTile;

   /**
    * The textures can be found in the Resources folder.
    */
   public ImageOfTiles(){
       iconToEachTile = new HashMap<>(MAXELEMENTS);
       iconToEachTile.put("1x","\\Resources\\pinyin7.png");
       iconToEachTile.put("2x","\\Resources\\pinyin8.png");
       iconToEachTile.put("3x","\\Resources\\pinyin9.png");
       iconToEachTile.put("4x","\\Resources\\pinyin10.png");
       iconToEachTile.put("5x","\\Resources\\pinyin11.png");
       iconToEachTile.put("6x","\\Resources\\pinyin12.png");
       iconToEachTile.put("7x","\\Resources\\pinyin13.png");
       iconToEachTile.put("8x","\\Resources\\pinyin14.png");
       iconToEachTile.put("9x","\\Resources\\pinyin15.png");
       iconToEachTile.put("1m","\\Resources\\bamboo1.png");
       iconToEachTile.put("2m","\\Resources\\bamboo2.png");
       iconToEachTile.put("3m","\\Resources\\bamboo3.png");
       iconToEachTile.put("4m","\\Resources\\bamboo4.png");
       iconToEachTile.put("5m","\\Resources\\bamboo5.png");
       iconToEachTile.put("6m","\\Resources\\bamboo6.png");
       iconToEachTile.put("7m","\\Resources\\bamboo7.png");
       iconToEachTile.put("8m","\\Resources\\bamboo8.png");
       iconToEachTile.put("9m","\\Resources\\bamboo9.png");
       iconToEachTile.put("1k","\\Resources\\circle1.png");
       iconToEachTile.put("2k","\\Resources\\circle2.png");
       iconToEachTile.put("3k","\\Resources\\circle3.png");
       iconToEachTile.put("4k","\\Resources\\circle4.png");
       iconToEachTile.put("5k","\\Resources\\circle5.png");
       iconToEachTile.put("6k","\\Resources\\circle6.png");
       iconToEachTile.put("7k","\\Resources\\circle7.png");
       iconToEachTile.put("8k","\\Resources\\circle8.png");
       iconToEachTile.put("9k","\\Resources\\circle9.png");
       iconToEachTile.put("1e","\\Resources\\fall.png");
       iconToEachTile.put("2e","\\Resources\\spring.png");
       iconToEachTile.put("3e","\\Resources\\summer.png");
       iconToEachTile.put("4e","\\Resources\\winter.png");
       iconToEachTile.put("1l","\\Resources\\lotus.png");
       iconToEachTile.put("2l","\\Resources\\orchid.png");
       iconToEachTile.put("3l","\\Resources\\chrysanthemum.png");
       iconToEachTile.put("4l","\\Resources\\peony.png");


    }
}
