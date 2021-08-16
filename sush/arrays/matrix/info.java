// this is how to apply dfs algorithm on the 2D matrix

    public void helper(int[][] mat, int row, int col, int color, int newColor){
        
	// boundary condition that is used
        if(row < 0 || col < 0 || row>=image.length || col>= image[0].length) {
            return;
        }

	// actual condition which is the basis of eliminating the wrong cases
	// mostly this changes in every question
        if(mat[row][col]!=color){
            return;
        }
	// this is where you mark the place as visited
        mat[row][col] = newColor;

        helper(mat, row-1, col, color, newColor);
        helper(mat, row, col-1, color, newColor);
        helper(mat, row+1, col, color, newColor);
        helper(mat, row, col+1, color, newColor);
        return;
    }
