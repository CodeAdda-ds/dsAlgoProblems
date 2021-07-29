class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        } 
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        
        if(leftHeight==0 || rightHeight==0){  // leaf condition
            return 1 + leftHeight + rightHeight;
        }
        else {
            return Math.min(leftHeight, rightHeight) + 1;
        }
    }
}
