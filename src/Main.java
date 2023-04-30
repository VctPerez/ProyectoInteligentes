import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        System.out.println(laberinto);
        laberinto.printMaze(false);

        A_algorithm.run(laberinto);
        
        System.out.println(laberinto);
        laberinto.printMaze(true);
        
    }
}
