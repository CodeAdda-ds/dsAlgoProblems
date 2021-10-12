// Problem link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// General template that will be used in a lot of questions

class Solution {
    boolean possible(int[] weights, int capacity, int days, int l){
        int daysRequired = 1;
        int tempCap = 0;
        for(int i=0; i < l; i++){
            tempCap += weights[i];
            if(tempCap > capacity){  // too heavy, wait for next day
                tempCap = weights[i];
                daysRequired += 1;
                if(daysRequired > days) {  // cannot ship in days days
                    return false;
                }
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0];  // left = max(weights) 
        int right = weights[0]; // right = sum(weights)
        int l = weights.length;
        for(int i=1; i  < l; i++){
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
	// think about the sample spaces of left and right

        while(left < right){
            int mid = left + (right-left)/2;
            if(possible(weights, mid, days, l)){ 
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

1. If we can discover some kind of monotonicity, for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.

2. It's not important that the array will be sorted and the left and right will be indices.
left and right represent the boundaries that can be taken by the answer.
here the answer will lie between left and right limits and
if possible(i) is true, then possible(i+1) will also be true

These two hints made us use binary search!

*/
