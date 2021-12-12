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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return preOrder;
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            preOrder.add(root.val);
            
            // stack is LIFO, hence take right and then left
            if(root.right!=null){
                st.add(root.right);
            } 
            if(root.left != null){
                st.add(root.left);
            }
        }
        return preOrder;
    }
}


// recursive approach
class Solution {
    List<Integer> preOrder = new ArrayList<>();
    public void recursiveFunc(TreeNode root){
        if(root==null){
            return;
        } 
        preOrder.add(root.val);
        recursiveFunc(root.left);
        recursiveFunc(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        recursiveFunc(root);
        return preOrder;
    }
}
