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
class Solution {
    public int findSum(TreeNode root,int targetSum,int sum)
    {
        if(root==null)
            return 0;
        sum=sum+root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum)
                return 1;
        }
        if(findSum(root.left,targetSum,sum)==1)
            return 1;
        else if(findSum(root.right,targetSum,sum)==1)
            return 1;
        return 0;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        int sum=0;
        if(findSum(root,targetSum,sum)==1)
            return true;
        return false;
    }
}