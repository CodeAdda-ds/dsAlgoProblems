// Solution 1 which checks only if the nodes are at same level: WRONG SOLUTION, needs some modificaiton

class Solution {    
    public int getLevel(TreeNode root, int value, int level){
        if(root==null)
          return 0;
          
        int result=getLevel(root.left,value,level+1) ;
        if(result!=0)
          return result;
        result= getLevel(root.right,value,level+1);
        return result;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        // check if the level is same

        
        int xLevel = getLevel(root, x, 1);
        int yLevel = getLevel(root, y, 1);
        
        if(xLevel==yLevel){
            return true;   
        } 
        return false;
        
    }
}


// Solution 2 which also checks if the root of both these nodes is also same

// check if they are at same level then their root shouldn't be same

class Solution {
    TreeNode a, b; // take these two temp Nodes to store the root of both p and q 
    
    public int getLevel(TreeNode root, int value, int level){
        if(root==null)
          return 0;
        if(root.left==null && root.right==null){
            return 0;
        }
        if(root.left!=null){
            if(root.left.val==value) { // if left exists and its value is matched, then just store the root in there just so we could compare later
                if(a==null){
                    a = root;
                } else if(b==null){
                    b = root;
                }
                return level;
            }
        }
        if(root.right!=null){
            if(root.right.val==value) {
                if(a==null){
                    a = root;
                } else if(b==null){
                    b = root;
                }
                return level;
            }
        }
        

          

        int result=getLevel(root.left,value,level+1) ;
        if(result!=0)
          return result;
        result= getLevel(root.right,value,level+1);
        return result;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {

        a= null;
        b = null;
        
        
        int xLevel = getLevel(root, x, 1);
        int yLevel = getLevel(root, y, 1);

        // check if they are at same level then their root shouldn't be same
        if(xLevel==yLevel && a!=b){
            return true;   
        } 
        return false;
        
    }
}
