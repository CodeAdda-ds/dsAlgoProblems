// Problem link: https://leetcode.com/problems/sqrtx/

// Basic Binary search question is, minimise k such that condition(k) is True


class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x+1;
        while(left < right){
            int mid = left + (right - left)/2;
            if( (mid+1)*(mid+1) >=0 && mid >= x/mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left-1;
    }
}






/* Points to remember:
search for minimal k satisfying condition k^2 > x, then k - 1 is the answer to the question

Solution is failing for larger values hence we need to use this:
mid >= x/mid
main concept samjho, python me chal jata hai solution
*/
