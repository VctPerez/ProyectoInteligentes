import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class A_algorithm {
    private static Set<Laberinto.Node> openSet = new HashSet(), closedSet = new HashSet();
    private static Map<Laberinto.Node, Integer> parent = new HashMap<>();

    private static int f;

    public static void run(Laberinto lab){
        lab.getStart().calculateG(null);
        f = lab.getStart().g + lab.getStart().h;
        openSet.add(lab.getStart());

        while(!openSet.isEmpty()){
            
        }

    }
    private void writeFile(){

    }
}