// Problem link: https://leetcode.com/problems/permutations/

class Solution {
    private void permutations(int[] nums, HashSet<Integer> map, ArrayList<Integer> tempList, int index, List<List<Integer>> ans){
        
        // base case
        if(tempList.size()==nums.length){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0; i < nums.length; i++){
            
            if(!map.contains(nums[i])){
                // add in solution and mark the value as processed
                tempList.add(nums[i]);
                map.add(nums[i]);
                permutations(nums, map, tempList, i+1, ans);
                
                // we mark the value we inserted as not visited taki aage ke operations me ye na lage ki ye value ko process karrna hi nahi hai 
                tempList.remove(tempList.size()-1);
                map.remove(nums[i]);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        permutations(nums, map, new ArrayList<>(), 0, ans);
        return ans;
    }
}

/* 

Time: O(n*n!) n! permutations * n elements
Space: O(n) + O(n)  ans array + map array 

Points to remember:

Use a set in backtracking problems to keep track of values which are yet to be added in solution and which are not



*/
