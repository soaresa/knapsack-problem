/**
 * @author Adalberto
 *
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapsackTest {

    @Test
    public void testRecursiveWithEmptyEntries() {
        assertEquals(0, Knapsack.recursiveSolution(105, 0, new int[0], new int[0]));
        assertEquals(0, Knapsack.dynamicSolution(105, 0, new int[0], new int[0]));
    }

    @Test
    public void testRecursiveAllObjectsWithWeightBiggerThanLimit() {
        int[] values  = {200,  50,  40,  30};
        int[] weights = {110, 500, 400, 300};
        assertEquals(0, Knapsack.recursiveSolution(100, 4, values, weights));
        assertEquals(0, Knapsack.dynamicSolution(100, 4, values, weights));
    }
    
    @Test
    public void testRecursiveBigObjectBigValue() {
        int[] values  = {200,  4,  3,  2};
        int[] weights = {100, 20, 30, 10};
        assertEquals(200, Knapsack.recursiveSolution(105, 4, values, weights));
        assertEquals(200, Knapsack.dynamicSolution(105, 4, values, weights));
    }
   
    @Test
    public void testRecursiveBigObjectSmallValue() {
        int[] values  = { 20, 50, 80, 40};
        int[] weights = {100, 50, 50, 60};
        assertEquals(170, Knapsack.recursiveSolution(200, 4, values, weights));
        assertEquals(170, Knapsack.dynamicSolution(200, 4, values, weights));
    }
    
    @Test
    public void testRecursiveObjectWeightBiggerThanLimit() {
        int[] values  = {200, 50, 40, 30};
        int[] weights = {100,  5,  4,  3};
        assertEquals(120, Knapsack.recursiveSolution(50, 4, values, weights));
        assertEquals(120, Knapsack.dynamicSolution(50, 4, values, weights));
    }
    
    @Test
    public void testRecursiveCombinationWithAll() {
        int[] values  = {200, 50, 40, 30};
        int[] weights = {100,  5,  4,  3};
        assertEquals(320, Knapsack.recursiveSolution(500, 4, values, weights));
        assertEquals(320, Knapsack.dynamicSolution(500, 4, values, weights));
    }
    
    @Test
    public void testRecursiveCombinationWithSubgroup() {
        int[] values  = {200, 50, 90, 55};
        int[] weights = {100,  5,  4,  3};
        assertEquals(345, Knapsack.recursiveSolution(107, 4, values, weights));
        assertEquals(345, Knapsack.dynamicSolution(107, 4, values, weights));
    }
    
    
   
        
    


            
}
