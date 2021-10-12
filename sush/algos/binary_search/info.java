// Refer: https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems

// basic template pseudo code
def binary_search(array) -> int:
    def condition(value) -> bool:
        pass

    left, right = min(search_space), max(search_space) // could be [0, n], [1, n] etc. Depends on problem
    while left < right:
        mid = left + (right - left) / 2
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    return left



// basic template code
// Problem statement generalised: Minimize k , such that condition(k) is True

public class Solution {
    public boolean conditionFunction(int mid) { 
	// code that will matter the most
    }
    public int answerfunction(int n) {
        int left = 0, right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if(conditionFunction(mid)){  // pass any number of parameters
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

If we can discover some kind of monotonicity, for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.
*/
