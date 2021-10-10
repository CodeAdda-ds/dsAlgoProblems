class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowArray = new boolean[row];
        boolean[] colArray = new boolean[col];
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(matrix[i][j]==0) {
                    rowArray[i] = true;
                    colArray[j] = true;
                }
            }
        }
        for(int i=0; i < row; i++){
            if(rowArray[i]){
                for(int j=0; j < col; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=0; j < col; j++){
            if(colArray[j]){
                for(int i=0; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


/* 
Points to remember: in a grid, see if we can save reference of changes that is required to be made
on the entire row/column
*/
