// https://leetcode.com/problems/sort-colors/

// Solution - 1
class Solution {
    public void sortColors(int[] nums) {
        int noOfZero = 0;
        int noOfOne = 0;
        int noOfTwo = 0;
        int l = nums.length;
        int counter = 0;
        for(int i=0; i< l; i++){
            if(nums[i]==0){
                noOfZero++;
            } else if(nums[i]==1){
                noOfOne++;
            } else {
                noOfTwo++;
            }
        }
        for(int i=0; i < l; i++){
            if(noOfZero > 0){
                nums[i] = 0;
                noOfZero--;
            } else if(noOfOne > 0){
                nums[i] = 1;
                noOfOne--;
            } else if(noOfTwo > 0){
                nums[i] = 2;
                noOfTwo--;
            }
        }
        
    }
}


// Solution - 2
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length -1;
        int temp;
        while (mid <= high){
            switch(nums[mid]){
                case 0:
                    // swap with low
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;                 
            }
        }
    }
}

// Points to remember: always think about the variety of values the array will have, can we count them each one's occurences?
// think about swapping when sorting is concerned
