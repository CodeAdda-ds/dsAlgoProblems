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
    
    public TreeNode createBST(int[] nums,int l,int r)
    {
        if(l<=r){
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums,l,mid-1);
        root.right = createBST(nums,mid+1,r);
        return root;
        }
        return null;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        return createBST(nums,0,length-1);
    }
}