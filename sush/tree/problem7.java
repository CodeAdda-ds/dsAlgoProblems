class Solution {
    List<Integer> output = new ArrayList<>();
    public void recursiveFunc(TreeNode temp){
            if(temp==null){
                return;
            }
            if(temp.left!=null){
                recursiveFunc(temp.left);                
            }
            output.add(temp.val);
            // System.out.print(temp.val);
            if(temp.right!=null){
                recursiveFunc(temp.right);                
            }
   
        }
    public List<Integer> inorderTraversal(TreeNode root) {
            recursiveFunc(root);
        return output;
    }
    
}
