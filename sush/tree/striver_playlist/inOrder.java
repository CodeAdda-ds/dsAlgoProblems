/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// iterative approach using Stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root==null) return inOrder;
        while(true){
            if(root!=null){
                st.push(root);
                root = root.left;
            } else {
                if(st.isEmpty()){
                    break;
                }
                root = st.pop();
                inOrder.add(root.val);
                root = root.right;
            }
        }
        return inOrder;
           
    }
    
}


// recursive approach
class Solution {
    List<Integer> inOrder = new ArrayList<>();
    public void recursiveFunc(TreeNode temp){
            if(temp==null){
                return;
            }
            if(temp.left!=null){
                recursiveFunc(temp.left);                
            }
            inOrder.add(temp.val);
            if(temp.right!=null){
                recursiveFunc(temp.right);                
            }
   
        }
    public List<Integer> inorderTraversal(TreeNode root) {
            recursiveFunc(root);
        return inOrder;
    }
    
}
