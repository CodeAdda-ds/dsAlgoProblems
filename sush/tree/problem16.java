class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val >= p.val && root.val <= q.val){ 
            return root;
        }
        if(root.val <= p.val && root.val >= q.val){
            return root;
        }
        
        // agar upar ki conditios meet nahi hui hai to fir left aur right me traverse karna padega
        TreeNode l = lowestCommonAncestor(root.left,p,q); 
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        //traverse karne pe dekkhna padega ki kahi left/right node null to nahi hai
        if(l!=null && r!=null){
            return root;
        }
        if(l!=null){
            return l;
        }
        return r;
        
    }
}
