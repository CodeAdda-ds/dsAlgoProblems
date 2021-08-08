class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int x = mat.length;
        int y = mat[0].length;
        if(r*c!=x*y)
            return mat;
        int[][] ans = new int[r][c];
        int l=0,m=0;
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(m>=c){
                    m=0;
                    l++;
                }
                ans[l][m]=mat[i][j];
                m++;
            }
        }
        return ans;
    }
}