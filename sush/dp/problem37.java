
// In this question, try to think in groups of three, what to do if we rob only one house or what happens when we rob both the first and the third houses

// Solution - 1
class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
	
	// base cases
        if (l==1) return nums[0];
        if(l<=2) return Math.max(nums[0], nums[1]);

        nums[1] = Math.max(nums[0], nums[1]);
	// if the sum of two numbers exceed the middle element, we will skip the middle house
        for(int i=2; i<l; i++){
            if(nums[i] + nums[i-2] > nums[i-1]){
                nums[i] += nums[i-2];
            } else {
		// if the middle number is greater than the sum of two numbers it's betweeen, we will rob it
                nums[i] = nums[i-1];
            }
        }
        return nums[l-1];
    }
}


// Solution - 2
import java.util.Arrays;
class Solution {
	// recursive function
    public int rec(int[] nums, int i, int[] mem){
        if(i<0) return 0;
        if(mem[i]!=-1) return mem[i];
	// take maximum of the cases when we rob two houses skipping the middle one, or just the middle
        mem[i]= Math.max(rec(nums,i-2,mem)+nums[i], rec(nums,i-1,mem));
        return mem[i];
    }
	// main func
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        int result = rec(nums, nums.length-1, mem);
        return result;
    }
}
