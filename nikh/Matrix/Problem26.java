class Solution {
    public boolean left(int[][] mat,int r,int c)
    {
        while(c>=0)
        {
            if(mat[r][c]==1)
                return false;
            c--;
        }
        return true;
    }
    
    public boolean right(int[][] mat,int r,int c)
    {
        while(c<mat[0].length)
        {
            if(mat[r][c]==1)
                return false;
            c++;
        }
        return true;
    }
    
    public boolean up(int[][] mat,int r,int c)
    {
        while(r>=0)
        {
            if(mat[r][c]==1)
                return false;
            r--;
        }
        return true;
    }
    
    public boolean down(int[][] mat,int r,int c)
    {
        while(r<mat.length)
        {
            if(mat[r][c]==1)
                return false;
            r++;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                {
                    if(left(mat,i,j-1)&&right(mat,i,j+1)&&up(mat,i-1,j)&&down(mat,i+1,j))
                        count++;
                }
            }
        }
        return count;
    }
}