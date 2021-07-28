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
 
 --------------------------------------------------------------------------
 Method-1
 Time Complexity = O(n^2);
 Space Complexity = O(n);
class Solution {
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int findLeaf(TreeNode root,int level)
    {
        if(root==null)
            return 0;
        if(level==1)
        {
            if(root.left==null && root.right==null){
                return 1;
            }
                
        }
        else if(level>1)
        {
            if(findLeaf(root.left,level-1)==1)
                return 1;
            if(findLeaf(root.right,level-1)==1)
                return 1;
        }
        return 0;
    }
    public int minDepth(TreeNode root) {
        int h = height(root);
        for(int i=1;i<=h;i++)
        {
            if(findLeaf(root,i)==1)
                return i;
        }
        return 0;
    }
}

------------------------------------------------------------------------------------------------------

Method-2
Time Complexity = O(n);
 Space Complexity = O(n);

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
//     public int height(TreeNode root)
//     {
//         if(root==null)
//             return 0;
//         return 1+Math.max(height(root.left),height(root.right));
//     }
//     public int findLeaf(TreeNode root,int level)
//     {
//         if(root==null)
//             return 0;
//         if(level==1)
//         {
//             if(root.left==null && root.right==null){
//                 return 1;
//             }
                
//         }
//         else if(level>1)
//         {
//             if(findLeaf(root.left,level-1)==1)
//                 return 1;
//             if(findLeaf(root.right,level-1)==1)
//                 return 1;
//         }
//         return 0;
//     }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        if(root.left==null)
            return 1+minDepth(root.right);
        else if(root.right==null)
            return 1+minDepth(root.left);
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}

------------------------------------------------------------------------------------------------
Method-3
Time Complexity = O(n);
 Space Complexity = O(n);
 
 