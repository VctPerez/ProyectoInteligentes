public class Main {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        
        
        A_algorithm algoritmo = new A_algorithm();
        algoritmo.run(laberinto);
        
        System.out.println(laberinto);
        
    }
}
