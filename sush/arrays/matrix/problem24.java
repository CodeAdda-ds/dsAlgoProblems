
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRows = mat.length;
        int matCols = mat[0].length;
        if(matRows*matCols==r*c){
            // logic
            int[][] output = new int[r][c];
            int x = 0;
            int y = 0;
            int value = 0;
            for(int i=0; i<matRows; i++){
                for(int j=0; j<matCols; j++){
                    value = mat[i][j];
                    if(y==c){ //row will change every c elements, y is acting as a counter
                        x++;
                        y=0; // reset the counter
                    }
                    output[x][y++] = value;
                }
            }
            return output;
        } else {
            return mat;
        }
    }
}
