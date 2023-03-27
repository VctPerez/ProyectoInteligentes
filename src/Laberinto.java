import java.util.Random;

public class Laberinto {
    protected class Node{
        int x,y,g,h;
        char tipo;
        Node(int x, int y, char tipo){
            this.x = x;
            this.y = y;
            setTipo(tipo);
        }
        void setTipo(char tipo){
            this.tipo = tipo;
        }

        void calculateG(Node anterior){
            if(anterior == null){
                g = 0;
            }else{
                g = anterior.g + Math.abs(x - anterior.x) + Math.abs(y - anterior.y);
            }
        }

        void calculateH(){
            h = Math.abs(y - getEnd().y) + Math.abs(x - getEnd().x);
        }

        @Override
        public String toString() {
            return String.valueOf(tipo);
        }
    }
    private int contObs = 0;
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
                if(prob <= PORC_OBSTACULO && contObs < FILAS * COLUMNAS * 30 / 100){
                    contObs++;
                    laberinto[i][j] = new Node(i,j,'*');
                    laberinto[i][j].calculateH();
                }else{
                    laberinto[i][j] = new Node(i,j,' ');
                }
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
        lab.append('\n' + "30% = ").append(FILAS * COLUMNAS * 30 / 100).append(" Numero de obstaculos: ").append(contObs);
        return lab.toString();
    }
}
