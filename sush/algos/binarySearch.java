// Below is the code to check if target exists in a sorted array using binary search

// Leetcode problem link: (https://leetcode.com/problems/binary-search/)

class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int mid = 0;
        if(low==high && nums[0]==target) return 0;
	// if target exceeded the boundaries of the array
        if(nums[low] > target || nums[high] < target){
                return -1;
        }
        while(low<high){
            mid = (low+high)/2;
            
            if(nums[low] <= target && nums[mid] >= target){
                high = mid;
                if(nums[low]==target) {
                    return low;
                } 
                if(nums[high]==target){
                    return high;
                }
            } else if(nums[mid]<target && nums[high]>= target){
                low = mid+1;
                if(nums[low]==target) {
                    return low;
                } 
                if(nums[high]==target){
                    return high;
                }
            }
        }
        return -1;
        
    }
}
