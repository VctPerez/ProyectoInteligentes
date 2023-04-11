import java.util.ArrayList;
import java.util.Random;

public class Laberinto {
    protected class Node{
    	int x,y;
    	char type;
    	Node bestPrev;
    	ArrayList<Node> neighbours;
    	int g,f,h;
    	boolean optimusPath;
    	
    	public Node(int x, int y, char type) {
    		
    		this.x = x;
    		this.y = y;
    		this.type = type;
    		
    		bestPrev = null;
    		neighbours = null;
    		g = -1 ; h = -1; f = -1;
    		
    		optimusPath = false;
    		
    	}
    	
        void setTipo(char tipo){
            this.type = tipo;
        }

        void calculateG(){
            if(bestPrev == null){
                g = 0;
            }else{
            	g = bestPrev.g + 1;
//                g = anterior.g + Math.abs(x - anterior.x) + Math.abs(y - anterior.y);
            }
        }

        void calculateH(){
            h = Math.abs(y - getEnd().y) + Math.abs(x - getEnd().x);
        }
        
        void calculateF() {
        	f = g + h;
        }

        @Override
        public String toString() {
//            return String.valueOf(type);
        	String res = "" + f;
        	return res;
        }
    }
    
    private final int FILAS = 60;
    private static int COLUMNAS = 80;
    private final double PORC_OBSTACULO = 0.30;
    private Node[][] laberinto;
    private Node start, end;

    public Node[][] getLaberinto() {
        return laberinto;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public Laberinto(){
        laberinto = new Node[FILAS][COLUMNAS];
        generarEstados('I');
        generarEstados('G');
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                double prob = Math.random();
                if(prob <= PORC_OBSTACULO){
                    //OBSTACULO
                    laberinto[i][j] = new Node(i,j,'*');
                }else{
                	//ESPACIO VACIO
                    laberinto[i][j] = new Node(i,j,' ');
                }
                laberinto[i][j].calculateH();
            }
        }
        laberinto[start.x][start.y] = start;
        laberinto[end.x][end.y] = end;

    }
    private void generarEstados(char estado){
        int x = new Random().nextInt(FILAS);
        int y = new Random().nextInt(COLUMNAS);
        if(estado == 'I'){
            start = new Node(x,y,estado);
        }
        else {
            end = new Node(x,y,estado);
        }
    }

    @Override
    public String toString() {
        StringBuilder lab = new StringBuilder();
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++) {
                lab.append(laberinto[i][j]);
            }
            lab.append('\n');
        }
        return lab.toString();
    }
}
