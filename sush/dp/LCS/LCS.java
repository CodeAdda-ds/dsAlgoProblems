// https://leetcode.com/problems/longest-common-subsequence/
// memoized code
import java.util.Arrays;
class Solution {
    int dp[][] = new int[1001][1001]; 
    public int LCS(String x, String y, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        if (x.charAt(m-1)==y.charAt(n-1)){
            return dp[m][n] = 1 + LCS(x, y, m-1, n-1);
        } else {
            return dp[m][n] = Math.max(LCS(x, y, m-1, n), LCS(x, y , m, n-1));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
	// general code to fill a 2d array with -1        
	for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int ans = LCS(text1, text2, text1.length(), text2.length());
        return ans;
    }
}
