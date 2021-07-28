class Solution {
    public TreeNode bst(int[] nums, int start, int end){
        
    if(start <= end){
        int mid = (start + end) / 2;
        TreeNode root =  new TreeNode(nums[mid]);
        root.left = bst(nums, start, mid-1);
        root.right = bst(nums, mid+1, end);
        return root;
    } else {
        return null;
    }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length-1);
        }
    }
