// Problem link: https://leetcode.com/problems/first-bad-version/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n; // sample space se set kiye soch ke
        while(left < right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){   // template function is already implemented
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
