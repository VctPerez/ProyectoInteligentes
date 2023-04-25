import java.util.*;

public class A_algorithm {
    private static SortedSet<Laberinto.Node> openSet = new TreeSet<>(new FComparator()), closedSet = new TreeSet<>(new FComparator());
    private static Map<Laberinto.Node, Laberinto.Node> parent = new HashMap<>();

    public static void run(Laberinto lab){
    	
        lab.getStart().calculateG();
        lab.getStart().calculateH();
        lab.getStart().calculateF();
        
        openSet.add(lab.getStart());
        System.out.println(openSet.toString());

        while(!openSet.isEmpty()){
            //System.out.println("si");
        	Laberinto.Node current = openSet.last();
            if(current.type == lab.getEnd().type){
                //System.out.println("hola");
                reconstruct_path(lab,current);
            }
            openSet.remove(current);
            closedSet.add(current);
            for(Laberinto.Node neighbor : getNeighbors(lab, current)){
                if(closedSet.contains(neighbor)){
                    continue;
                }
                int tentative_g = current.g + 1;
                neighbor.calculateG();
                if(!openSet.contains(neighbor) || tentative_g < neighbor.g) { // || tentaive_g < neighbour.g
                    neighbor.bestPrev = current;
                    neighbor.g = tentative_g;
                    neighbor.calculateF();
                    openSet.add(neighbor);
                }
            }
        }

    }

    private static void reconstruct_path(Laberinto lab, Laberinto.Node current) {
        //System.out.println("recontruye");
        if(current.type != lab.getStart().type){
            System.out.println("hola2");
            current.setTipo('+');
            reconstruct_path(lab,current.bestPrev);
        }
    }

    private static List<Laberinto.Node> getNeighbors(Laberinto lab, Laberinto.Node node){
        List<Laberinto.Node> neighbors = new ArrayList<>();

        if(node.x > 0){
            if(lab.getNode(node.x - 1, node.y).type != '*')neighbors.add(lab.getNode(node.x - 1, node.y));
        }
        if(node.x < Laberinto.COLUMNAS - 1){
            if(lab.getNode(node.x + 1, node.y).type != '*')neighbors.add(lab.getNode(node.x + 1, node.y));
        }
        if(node.y > 0){
            if(lab.getNode(node.x, node.y - 1).type != '*')neighbors.add(lab.getNode(node.x, node.y - 1));
        }
        if(node.y < Laberinto.FILAS - 1){
            if(lab.getNode(node.x, node.y + 1).type != '*') neighbors.add(lab.getNode(node.x, node.y + 1));
        }
        return neighbors;
    }
    private static Laberinto.Node lowestFvalue() {
        return null;
    }

    private void writeFile(){
    	
    }
}

class FComparator implements Comparator<Laberinto.Node> {
	@Override
	public int compare(Laberinto.Node n1 , Laberinto.Node n2) {
		return -Integer.compare(n1.f, n2.f);
	}
}