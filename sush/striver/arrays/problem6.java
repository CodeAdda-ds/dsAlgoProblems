class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
         
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        
        slow = nums[0]; // cycle detected, and the fast pointer is pointing at it
        
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
        
    }
}


// Points to remember: we can check if a cycle exists in an array/linkedlist using the upper half of code
