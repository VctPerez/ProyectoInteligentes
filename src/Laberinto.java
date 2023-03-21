import java.util.Random;

public class Laberinto {
    private class Node{
        int x,y,f,g,h;
        char tipo;
        Node(int x, int y, char tipo){
            this.x = x;
            this.y = y;
            setTipo(tipo);
        }
        void setTipo(char tipo){
            this.tipo = tipo;
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

    public Laberinto(){
        laberinto = new Node[FILAS][COLUMNAS];

        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                double prob = Math.random();
                if(prob <= PORC_OBSTACULO && contObs < FILAS * COLUMNAS * 30 / 100){
                    contObs++;
                    laberinto[i][j] = new Node(i,j,'*');
                }else{
                    laberinto[i][j] = new Node(i,j,' ');
                }
            }
        }
        generarEstados('I');
        generarEstados('G');
    }
    private void generarEstados(char estado){
        int x = new Random().nextInt(FILAS);
        int y = new Random().nextInt(COLUMNAS);

        laberinto[x][y].setTipo(estado);
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
