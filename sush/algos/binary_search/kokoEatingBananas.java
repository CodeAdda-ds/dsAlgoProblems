// Problem Link: https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public boolean possible(int[] piles, int mid, int h, int l){
        int tempCap = 0;
        double hReq = 0; 
        for(int i=0; i < l; i++){
            hReq += Math.ceil((double)piles[i]/mid); // we cannot go to the next pile that dayif the pile is over
            if(hReq > (double) h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        int l = piles.length;
        for(int i=0; i < l; i++){
            right = Math.max(right, piles[i]);
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(possible(piles, mid, h, l)){
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

1. Typecasting: 
hReq += Math.ceil((double)piles[i]/mid);
            if(hReq > (double) h){
                return false;
            }

2. Think carefully about the boundaries i.e. left and right. left and right represent k here.

*/
