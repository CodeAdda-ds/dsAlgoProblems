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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int count=0;
            while(size>0)
            {
                TreeNode temp = q.peek();
                q.remove();
                TreeNode l = temp.left;
                TreeNode r = temp.right;
                if(l!=null && r!=null){
                    if((l.val ==x && r.val==y)||(l.val ==y && r.val==x))
                        return false;
                }
                if(l!=null)
                {
                    if(l.val==x || l.val ==y)
                        count++;
                    q.add(l);
                }
                if(r!=null)
                {
                    if(r.val==x || r.val==y)
                       count++;
                    q.add(r);
                }  
                size--;
            }
            if(count==2)
                return true;
            if(count==1)
                return false;
        }
         return false;
    }
}