class Solution {
    public int rec(int n, int[] mem){
        if(n==1) return 1;
        if(n==2) return 2;
        if(mem[n-1]!=0){
            return mem[n-1];
        }
        int temp = rec(n-1, mem) + rec(n-2, mem); // we'll either take one step or two steps
        mem[n-1]=temp;
        return temp;
    }
    public int climbStairs(int n) {
        int[] mem = new int[n];
        
        int result = rec(n, mem);
        return result;
    }
}
