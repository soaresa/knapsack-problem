/**
 * @author Adalberto
 *
 */
 
import java.util.Random;

/**
 * Solves my blog post problem: "Knapsack to Mars: A Combinatorial Optimization Tale"
 **/

public class KnapsackToMars {
    
    public static void main(String[] args) {
               
        // Generate random library
        long start = System.currentTimeMillis();
        int n = 50000;
        int g = 5000;
        int[] weights = new int[n];
        int[] values = new int[n];
        Random randRank   = new Random();
        Random randWeight = new Random();
        for (int i = 0; i < n; i++) {
            values[i] = randRank.nextInt(1000); 
            weights[i] = randWeight.nextInt(g);
        }
        long end = System.currentTimeMillis();
        System.out.println("Initialized lib: " + (end- start));
               
        // Track algorithm execution time
        start = System.currentTimeMillis();
        int d = Knapsack.dynamicSolution(g, n, values, weights);
        end = System.currentTimeMillis();
        System.out.println("Max value selected: " + d + " time: " + (end - start));

    }
}


