// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

// if the size of array 1 is (n + m): https://leetcode.com/problems/merge-sorted-array/

// if the size of array 1 is (n + m), we can actually start comparing from last and put elements in the last

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n;
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[last-1] = nums1[m-1];
                m -= 1;
                
            } else {
                nums1[last-1] = nums2[n-1];
                n-=1;
            }
            last -= 1;
        }
        while(n > 0){
            nums1[last-1] = nums2[n-1];
            n -= 1;
            last -= 1;
        }
    }
}



// when the array does not have extra space, we will compare the values and swap when required

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        for(int i=0; i < n; i++){
            if(arr1[i] > arr2[0]){
                // swap 
                long temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }
            long value = arr2[0]; // saving the first element because we will insert it somewhere in second array
            int j;
            for(j=1; j < m && arr2[j] < value; j++){ 
                // shifting until we find the place to insert the value
                arr2[j-1] = arr2[j];
            }
            arr2[j-1] = value;
        }
        
    }
}
// this was a n*m solution, there is an even better solution with gap algorithm


// Points to remember: swapping can be used when dealing with sorting (one or more arrays)
// when we are given an already sorted array, and only one element is misplaced, just think what if 
// we simply insert it to its place? How costly would that be? Sometimes that produces good solutions
