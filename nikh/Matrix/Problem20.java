Solution-1

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n = mat[0].length;
        int m = n;
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(j<m){
                sum = sum+mat[i][j];
                mat[i][j]=0;
            }
            j++;
        }
        j=m-1;
        
         for(int i=0;i<n;i++)
         {
             if(j>=0 && mat[i][j]!=0)
            {
                 sum =sum+mat[i][j];
            }
             j--;
         }
        return sum;
    }
}


Solution-2

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n = mat[0].length;
        int m = n;
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(j<m){
                sum = sum+mat[i][j];
                //mat[i][j]=0;
            }
            j++;
        }
        j=m-1;
        for(int i=0;i<n;i++)
        {
            if(j>=0 && i!=j)
                sum =sum+mat[i][j];
            j--;
        }
        // for(int i=0;i<n;i++)
        // {
        //     if(j>=0 && mat[i][j]!=0)
        //     {
        //         sum =sum+mat[i][j];
        //     }
        //     j--;
        // }
        return sum;
    }
}