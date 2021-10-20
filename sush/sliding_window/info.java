Sliding Window Technique is a method for finding subarrays in an array that satisfy given conditions. 

We do this via maintaining a subset of items as our window, and resize and move that window within the larger list until we find a solution. 

Sliding Window Technique is a subset of Dynamic Programming(breaking a problem into subproblems)
maintaining a subarray that satisfies given set of conditions is our subproblem.


Time complexity = O(n)
Space complexity = O(1)

We can use this technique to find subarrays inside large arrrays, find max/min or common substring
related questions





--------------------------------------------------------------------
Basic template

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int left = 0, right = 0;
        int sum = 0;
        int totalMax = Integer.MIN_VALUE;
        while(right < N){
            // calculation hogi yahan par taking right (mostly)
            if(right - left + 1 < K){
                right++; 
            } else if(right - left + 1 == K){ // maintaining the size of window
                // find answers from calculation
		
		// slide the window
            }
            
        }
        return totalMax;
    }
}
