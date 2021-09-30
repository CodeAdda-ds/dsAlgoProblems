// https://leetcode.com/problems/maximum-subarray/

// first discuss the N^3 solution with interviewer

for(i --> 0 to n-1){
    for(j --> i to n-1){
        for(k --> i to j){
            sum += nums[k]
            maxi = max(maxi, sum)
        }
    }
}

// if interviewer asks you to optimise it, go to N^2

for(i --> 0 to n-1){
    sum = 0
    for(j --> 0 to n-1){
            sum += nums[k]
            maxi = max(maxi, sum)
    }
}

// now you come to Kadane's algorithm

class Solution {
    public int maxSubArray(int[] nums) {
        int maxTotal = nums[0];
        int maxUntilNow = 0;
        for(int i=0; i<nums.length; i++){
            maxUntilNow += nums[i];
            maxTotal = Math.max(maxTotal, maxUntilNow);
            if(maxUntilNow < 0){
                maxUntilNow = 0;
            }
        }
        return maxTotal;
    }
}


