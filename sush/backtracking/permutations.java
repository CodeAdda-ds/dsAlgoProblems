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


-------------------------------------------------------------------------------------------------------

// Solution without map/set
// just check if the value exists in your current tempList

class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(list, new ArrayList<>(), nums);
       return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
       if(tempList.size() == nums.length){
          list.add(new ArrayList<>(tempList));
       } else{
          for(int i = 0; i < nums.length; i++){ 
             if(tempList.contains(nums[i])) continue; // element already exists, skip
             tempList.add(nums[i]);
             backtrack(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }
       }
    } 
}

/* 

Time: O(n*n!) n! permutations * n elements
Space: O(n) (tempList)

Points to remember:

if(tempList.contains(nums[i])) continue; 
this can be used a lot in backtracking problems

*/
