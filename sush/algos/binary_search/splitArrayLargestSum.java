
// Problem link: https://leetcode.com/problems/split-array-largest-sum/

class Solution {
    public boolean possible(int[] nums, int m, int mid, int l){
        int mReq = 1;
        int tempCap = 0;
        for(int i=0; i < l; i++){
            tempCap += nums[i];
            if(tempCap > mid){
                mReq++;
                tempCap = nums[i];
                if(mReq > m){
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int m) {
        int left = Integer.MIN_VALUE, right = 0; 
        int l = nums.length;
        for(int i=0; i < l; i++){
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(possible(nums, m, mid, l)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*

*/
