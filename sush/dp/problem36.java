//Solution - 1
// if we can change the input array
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i=2; i<cost.length; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}



// Solution - 2
// if we can't change the input array
import java.util.Arrays;
class Solution {
    
    // recursive function
    public int minCost(int[] cost, int i, int[] mem){
        if(i>=cost.length) return 0;
        if(mem[i]!=-1) return mem[i];
        
        int oneCost = cost[i] + minCost(cost,i+1,mem);
        int twoCost = cost[i] + minCost(cost,i+2,mem);
        int minValue = Math.min(oneCost, twoCost);
        mem[i] = minValue;
        return mem[i];
    }
    // main func
    public int minCostClimbingStairs(int[] cost) {
        
        int l = cost.length;
        int[] mem = new int[l];
        Arrays.fill(mem,-1);
        int result = Math.min(minCost(cost,0,mem), minCost(cost,1,mem)); // start either with 0 or 1 and get the minimum
        return result;
        
    }
}
