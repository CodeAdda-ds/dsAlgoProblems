// Problem link: https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left  < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*

Points to remember:

1. We are looking for the minimal k value satisfying nums[k] >= target, and we can just copy-paste our template. 

2. Notice that the input target might be larger than all elements in nums and therefore needs to placed at the end of the array. That's why we should initialize right = nums.length instead of nums.length - 1.

*/
