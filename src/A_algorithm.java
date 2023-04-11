import java.util.Comparator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class A_algorithm {
    private static SortedSet<Laberinto.Node> openSet, closedSet;
    private static Map<Laberinto.Node, Laberinto.Node> parent = new HashMap<>();

    
    private static int f;
    
    public A_algorithm() {
    	openSet = new TreeSet<>(new FComparator());
    }

    public static void run(Laberinto lab){
    	
        lab.getStart().calculateG();
        lab.getStart().calculateH();
        
        f = lab.getStart().g + lab.getStart().h;
        lab.getStart().calculateF();
        
        openSet.add(lab.getStart());
        System.out.println(openSet.toString());

        while(!openSet.isEmpty()){
        	
        }

    }
    private void writeFile(){
    	
    }
}

class FComparator implements Comparator<Laberinto.Node> {
	@Override
	public int compare(Laberinto.Node n1 , Laberinto.Node n2) {
		return Integer.compare(n1.f, n2.f);
	}
}