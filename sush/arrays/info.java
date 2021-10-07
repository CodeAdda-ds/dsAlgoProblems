// when you are allowed to use only constant space:
// -> if array elements are from 1 to n (array length), think in terms of index with value
// -> to mark a number visited, multiply the number at that number's index with -1
// refer this example to find duplicates

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] *= -1;
            } else {
                ans.add(Math.abs(nums[i]));
            }
        }
        return ans;
    }
}
