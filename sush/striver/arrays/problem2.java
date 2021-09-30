// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1#

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] ans = new int[2];
	// just marking visited, if visited already it's repeated
        for(int i=0; i<n; i++){
            if(arr[Math.abs(arr[i])-1] < 0){
                ans[0] = Math.abs(arr[i]);
            } else {
                arr[Math.abs(arr[i])-1] *= -1;
            }
        }
	// the number which is negative, i.e. not visited is missing
        for(int i=0; i< n; i++){
            if(arr[i]>0){
                ans[1] = i + 1;
            }
        }
        return ans;
    }
}


// Points to remember: return new int[2]{0,1};
// Also discuss the solution where you calculate the sum of numbers and sum of squares of numbers
// then subtract from natural number sum to get X and Y equation, but we won't use it because memory


