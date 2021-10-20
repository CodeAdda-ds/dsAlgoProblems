// Problem link: https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1#

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){

        int left = 0, right = 0;
        int sum = 0;
        int totalMax = Integer.MIN_VALUE;
        while(right < N){
            sum += Arr.get(right); // calculation with right pointer
            if(right - left + 1 < K){
                right++; 
            } else if(right - left + 1 == K){
                totalMax = Math.max(sum, totalMax);  // find answer from calculation

		// sliding the window forward
                sum -= Arr.get(left);  // window aage badha rahe hain to peeche wala hatana hoga
                right++;
                left++;
                
            }
            
        }
        return totalMax;
    }
}
