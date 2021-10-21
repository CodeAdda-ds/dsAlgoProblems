// Problem link: https://leetcode.com/problems/subsets/


class Solution {
    public void backtracking(List<List<Integer>> ans, int[] nums, int start, List<Integer> tempList){
        // base case
        ans.add(new ArrayList<>(tempList));  // adding a copy to the an
        for(int i=start; i < nums.length; i++){
            tempList.add(nums[i]);  
            backtracking(ans, nums, i+1, tempList);
            tempList.remove(tempList.size()-1);
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, nums, 0, new ArrayList<>());
        return ans;
    }
}


/*

Points to remember:

ans.add(new ArrayList<>(tempList)); 

adding a copy of a tempList, not original

*/
