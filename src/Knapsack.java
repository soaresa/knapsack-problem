/**
 * @author Adalberto
 *
 */

import java.util.Random;

/**
 * Two methods to solve combinatorial knapsack problem. 
 * Recursive method and dynamic programming method.
 * 
 * Given a capacity, number of items, values and weights 
 * they find the maximum sum of values where 
 * the sum of weights does not surpass capacity.
 */
 
public class Knapsack {
    
    public static int recursiveSolution(int capacity, int n, int[] values, int[] weights) {
        // Iteration ends or capacity depleted
        if (n == 0 || capacity == 0) {
            return 0;
        }
        
        // Index of next element to check
        int i = n - 1;
        
        if (weights[i] > capacity) {
            // Item i cannot be part of solution
            return recursiveSolution(capacity, i, values, weights);
        }
        
        // Solution with item i
        int resultIn = values[i] + recursiveSolution(capacity - weights[i], i, values, weights);

        // Solution without item i
        int resultOut = recursiveSolution(capacity, i, values, weights);
        
        // Select maximum value of item possibilities
        return Math.max(resultIn, resultOut);

    }
    
    public static int dynamicSolution(int capacity, int n, int[] values, int[] weights) {
        int[][] memo = new int[capacity+1][n+1];
        
        // Calculate capacity x n solutions from bottom up
        // Note: for i in {0, 1} and j in {0, 1} => memo[i][j] == 0
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i-1] <= w) {
                    int itemOut = memo[w][i-1];                             // solution for w without item i-1
                    int itemIn  = values[i-1] + memo[w-weights[i-1]][i-1];  // solution for w with item i-1
                    memo[w][i]  = Math.max(itemIn, itemOut);
                } else {
                    memo[w][i] = memo[w][i-1];  // item i-1 does not fit weight w
                }
            }
        }
        return memo[capacity][n];
    }
    
    /* COMPARE PERFORMANCE OF BOTH METHODS */
    public static void main(String[] args) {        
        int t = 50;
        int g = 1000000;
        int randW = g/2;
        long start;
        long end;        
        
        System.out.println("Weight limit: " + g + ", rand w: " + randW);
        System.out.println();
        
        int libs = 5;
        int[] libSizes = new int[] {15, 30, 45, 60, 75};
        int[] resultsRec = new int[libs];
        int[] resultsDyn = new int[libs];
        
        // Sample t times
        for (int i = 0; i < t; i++) {
            System.out.println();
            System.out.println("Sample: " + i);
            System.out.println();
            
            // Solve both methods for each library size
            for (int j = 0; j < libs; j++) {    
                int n = libSizes[j];
                System.out.println("Lib: " + n);
                
                // Initialize random library size n
                int[] values  = new int[n];
                int[] weights = new int[n];
                Random randValue  = new Random();
                Random randWeight = new Random();
                for (int h = 0; h < n; h++) {
                    values[h]  = randValue.nextInt(1000); 
                    weights[h] = randWeight.nextInt(randW);
                }
                
                // Solve recursive 
                start = System.currentTimeMillis();
                int r = Knapsack.recursiveSolution(g, n, values, weights);
                end = System.currentTimeMillis();
                long rt = end - start; 
                resultsRec[j] += rt;
                System.out.println("R: " + r + ", time: " + rt);
                           
                // Solve dynamic
                start = System.currentTimeMillis();
                int d = Knapsack.dynamicSolution(g, n, values, weights);
                end = System.currentTimeMillis();
                long dt = end - start;
                resultsDyn[j] += dt;
                System.out.println("D: " + d + ", time: " + dt);
                System.out.println();
                
            }
        }
        
        // Print average time of each method for each library size 
        System.out.println("Average time per lib size with " + t + " samples:");
        System.out.println();
        System.out.println("Recursive:");
        for (int i = 0; i < libs; i++) {
            System.out.println(resultsRec[i]/t);
        }
        System.out.println();
        System.out.println("Dynamic P.:");
        for (int i = 0; i < libs; i++) {
            System.out.println(resultsDyn[i]/t);
        }
    }
}