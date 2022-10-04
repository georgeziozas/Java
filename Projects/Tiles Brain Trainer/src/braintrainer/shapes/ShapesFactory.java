package braintrainer.shapes;
import java.util.ArrayList;
import java.util.List;

public class ShapesFactory {
    
    int sximata = 6;
    public List<String> tipoi_sximaton;
    
    public ShapesFactory(){
        tipoi_sximaton = new ArrayList<>(sximata);
        tipoi_sximaton.add("Kiklos");
        tipoi_sximaton.add("Tetragono");
        tipoi_sximaton.add("Trigono");
        tipoi_sximaton.add("Romvos");
        tipoi_sximaton.add("OrthogParalilogramo");
        tipoi_sximaton.add("Joker");
    }
    //use getShape method to get object of type shape 
    public Tiles_Btn getShape(int index_flag, String shape_Type,String kindOfDrawOnTile) {
        
        if (shape_Type == null) {
            return null;
        }
        switch (shape_Type) {
            case "Kiklos":
                return new Kiklos(index_flag,kindOfDrawOnTile);
            case "Tetragono":
                return new Tetragono(index_flag,kindOfDrawOnTile);
            case "Trigono":
                return new OrthogParalilogramo(index_flag,kindOfDrawOnTile);
            case "Romvos":
                return new Romvos(index_flag,kindOfDrawOnTile);
            case "OrthogParalilogramo":
                return new OrthogParalilogramo(index_flag,kindOfDrawOnTile);
            case "Joker":
                return new Joker(index_flag,kindOfDrawOnTile);
        }
      
        return null;
    }
}
