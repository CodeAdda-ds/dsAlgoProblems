class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        int[] hashTable = new int[n];  
        ArrayList<Integer> output = new ArrayList<Integer>(0);
        for(int i=0; i < arr.length; i++){
            if(hashTable[arr[i]]==0){
                hashTable[arr[i]] += 1;
            } else if (hashTable[arr[i]]==1){
                hashTable[arr[i]] = 2;
            }
        }
        for(int index=0; index < hashTable.length; index++){
            if(hashTable[index]==2){
                output.add(index);
            }
        }
        if(output.size()==0){
            output.add(-1);
        }
        return output;
        }
}


// in place algorithm, constant space

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] *= -1; // mark the number visited
            } else {
                ans.add(Math.abs(nums[i]));
            }
        }
        return ans;
    }
}
