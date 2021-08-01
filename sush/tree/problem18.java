// second best solution

class Solution {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }   
	// either the current diameter will be the largest or the previous one, hence we take max of all
        return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),height(root.left) + height(root.right));
    }
}

// the solution can be optimised by not calling the diameterOfBinary function every time, we are calling the funciion more than once

class Solution {
    int output = 0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        output = Math.max(output, l+r); //we're eliminating the shorter value here only!
        return 1 + Math.max(l,r); // this is just to calculate height
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }   
        int temp = height(root); // this is just to call the function
        return output;
        
        // return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),height(root.left) + height(root.right));
    }
}
