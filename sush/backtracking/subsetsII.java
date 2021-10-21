// Problem link: https://leetcode.com/problems/subsets-ii/

class Solution {
    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> tempList, int[] nums, int index){
        ans.add(new ArrayList<>(tempList));
        for(int i=index; i < nums.length; i++){
            if(i > index && nums[i]==nums[i-1]) continue;
            tempList.add(nums[i]);
            backtrack(ans, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
}


/*

Points to remember: 

if(i > index && nums[i]==nums[i-1]) continue;
current case ko ignore karega baki aage badh jayega,
can't use return kyoki it skips all the answers we could have gotten from later values


to take care of duplicates:
if(i > index && nums[i]==nums[i-1]) continue;

*/
