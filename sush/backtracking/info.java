// basic template

public List<List<Integer>> solution(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);   // when required, not always
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    // usually base case comes here, when would we find an answer?    
    list.add(new ArrayList<>(tempList)); 
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]); // add in our answer/ mark somewhere that we added
        backtrack(list, tempList, nums, i + 1); // go ahead for other values
        tempList.remove(tempList.size() - 1); // remove what we just added/mark that we have not yet added 
    }
}
