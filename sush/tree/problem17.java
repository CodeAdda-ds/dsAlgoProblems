class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        
        
        // matlab left/right me p/q value mil gayi hai, obviously vo meet to root pe hi honge upar jaake
        if(l!=null && r!=null){ 
            return root;
        }
        if(l!=null){
            return l;
        }
        return r;
    }
}
