import java.util.*;

public class A_algorithm {
    private static PriorityQueue<Laberinto.Node> openSet = new PriorityQueue<>(new FComparator()), closedSet = new PriorityQueue<>(new FComparator()); 
    private static boolean pathFound = false;

    public static void run(Laberinto lab){
    	
        lab.getStart().calculateG();
        lab.getStart().calculateH();
        lab.getStart().calculateF();
        
        openSet.add(lab.getStart());
        while(!openSet.isEmpty()){
        	Laberinto.Node current = openSet.peek();
            if(current.type == lab.getEnd().type){
                reconstruct_path(lab,current.bestPrev);
                pathFound = true;
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
        
        if(!pathFound) {
        	System.err.println("Camino no encontrado");
        }
        
    }

    private static void reconstruct_path(Laberinto lab, Laberinto.Node current) {
        if(current.type != lab.getStart().type ){
            current.setTipo('+');
            reconstruct_path(lab,current.bestPrev);
        }
    }

    private static List<Laberinto.Node> getNeighbors(Laberinto lab, Laberinto.Node node){
        List<Laberinto.Node> neighbors = new ArrayList<>();

        if(node.x > 0){
            if(lab.getNode(node.x - 1, node.y).type != Laberinto.obstaculo)neighbors.add(lab.getNode(node.x - 1, node.y));
        }
        if(node.x < Laberinto.FILAS - 1){
            if(lab.getNode(node.x + 1, node.y).type != Laberinto.obstaculo)neighbors.add(lab.getNode(node.x + 1, node.y));
        }
        if(node.y > 0){
            if(lab.getNode(node.x, node.y - 1).type != Laberinto.obstaculo)neighbors.add(lab.getNode(node.x, node.y - 1));
        }
        if(node.y < Laberinto.COLUMNAS - 1){
            if(lab.getNode(node.x, node.y + 1).type != Laberinto.obstaculo) neighbors.add(lab.getNode(node.x, node.y + 1));
        }
        return neighbors;
    }
    
}

class FComparator implements Comparator<Laberinto.Node> {
	@Override
	public int compare(Laberinto.Node n1 , Laberinto.Node n2) {
		//return n1.f == n2.f ? Integer.compare(n1.g, n2.g): Integer.compare(n1.f, n2.f);
        return Integer.compare(n1.f, n2.f);
	}
}