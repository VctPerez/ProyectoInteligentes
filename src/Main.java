import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        System.out.println(laberinto);

        A_algorithm.run(laberinto);
        
        System.out.println(laberinto);
        /*TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        });
        set.add(1);
        set.add(10);
        set.add(5);
        set.add(2);
        for(int i : set){
            System.out.println(i);
        }*/
        
    }
}
