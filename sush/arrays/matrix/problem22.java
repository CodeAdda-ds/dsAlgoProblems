class Solution {
    public int maximumWealth(int[][] accounts) {
        int rows = accounts.length;
        int cols = accounts[0].length;
        int maxSum = 0;
        int sum = 0;
        for(int i=0; i< rows; i++){
            for(int j =0; j < cols; j++){
                sum += accounts[i][j];
            }
            if(sum > maxSum){
                maxSum = sum;
            } 
            sum = 0;
        }
        return maxSum;
    }
}
