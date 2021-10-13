// Problem link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

class Solution {
    public boolean possible(int[] bloomDay, int m, int k, int mid, int l){
        int bouquets=0, flowers=0;
        for(int i=0; i < l; i++){
            if(bloomDay[i] > mid){  // mid represents no of days required
                flowers = 0;
            } else {
                bouquets += (flowers+1)/k; // blossom karwa ke bouquet banwa do
                flowers = (flowers+1)%k;  // bache hue flowers jinka blossom hona baki hai
            }
        }
        return bouquets>=m; 
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = bloomDay.length;
        // kitne bhi din wait kar lo nahi ban sakte bouquets, only possible when not enough flowers
        if(l < m*k) return -1;
        
        int left = 0;
        int right = Integer.MIN_VALUE;
        for(int i=0; i < l; i++){
            right = Math.max(right, bloomDay[i]);
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(possible(bloomDay, m, k, mid, l)){
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

If this is not going correct result:

bouquets += (flowers)/k;
flowers = (flowers)%k;

Try by adding +1 in operations to cover the boundary cases which might have been causing the issue

bouquets += (flowers+1)/k;
flowers = (flowers+1)%k;

*/


