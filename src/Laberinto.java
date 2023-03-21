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
    }
    private final int FILAS = 60;
    private static int COLUMNAS = 80;
    private final double PORC_OBSTACULO = 0.3;
    private Node[][] laberinto;

    public Laberinto(){
        laberinto = new Node[FILAS][COLUMNAS];

        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                double prob = Math.random();
                if(prob <= PORC_OBSTACULO){
                    laberinto[i][j] = new Node(i,j,'*');
                }else{
                    laberinto[i][j] = new Node(i,j,' ');
                }
            }
        }
    }

}
