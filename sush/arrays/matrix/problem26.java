class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;
        int[] r = new int[rows];
        int[] c = new int[cols];
        
        // mark in our temp arrays on which row and column we found 1
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==1){
                    r[i] += 1;
                    c[j] += 1;
                    
                }
            }
        }
        // for(int i=0;i<r.length;i++){
        //     System.out.print(r[i] +" ");
        //     }
        // System.out.println();
        // for(int i=0;i<c.length;i++){
        //     System.out.print(c[i] +" ");
        // }
        
        // if there was 1 found on a position, check if it was found only once in that row and column
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==1){
                    if(r[i]==1 && c[j]==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
