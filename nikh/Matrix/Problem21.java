class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix[0].length;
        int k = l-2;
     for(int i=0;i<l/2;i++)
     {
         for(int j=i;j<=k;j++)
         {
             int temp = matrix[i][j];
             matrix[i][j] = matrix[l-1-j][i];
             matrix[l-1-j][i] = matrix[l-1-i][l-1-j];
             matrix[l-1-i][l-1-j] = matrix[j][l-1-i];
             matrix[j][l-1-i] = temp;
         }
         k--;
     }
    }
}