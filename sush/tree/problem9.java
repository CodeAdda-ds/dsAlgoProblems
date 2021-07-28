class Solution {
    public boolean traversal(TreeNode l, TreeNode r){
        if(l==null && r==null){
            return true;
        }
        if(l==null || r==null){
            return false;
        }
        if(l.val==r.val){
            return true && traversal(l.left, r.right) && traversal(l.right, r.left);
        }
        return false;
        
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(traversal(root.left, root.right)){
            return true;
        }
        return false;
    }
}
