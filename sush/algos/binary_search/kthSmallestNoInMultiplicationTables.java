// Problem link: https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

class Solution {
    public boolean possible(int m, int n, int mid, int k){
        int kValue=0;
        for(int i=1,j=n; i <= m; i++){
            while(j>0 && j*i>mid)j--; // reach that j where we first find the expected solution
            if(j==0) break;
            kValue += j; // since we've found the j where we first found the expected solution, we don't need to check for smaller j values, ofcourse i*j will be smaller than mid for them!
        }
        return kValue>=k;
    }
    public int findKthNumber(int m, int n, int k) {
        int left=1;
        int right = m*n;
        if(m==1 && n==1 && k==1) return 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(possible(m, n, mid, k)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*
Points to remember:
*/

// 1. this can also be done using minheap but it is taking more time. But discuss this solution in interview
class Solution {
    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                heap.add((i+1)*(j+1));  // O(logn) time for insertion
            }
        }
        int ans = 0;
        while(k-->0){
            ans = heap.poll();  // O(logn) time for deletion
        }
        return ans;
    }
}

// 2. We can use binary search and do it like this:
class Solution {
    public boolean possible(int m, int n, int mid, int k){
        int kValue=0;
        for(int i=1; i <= m; i++){
            for(int j=1; j <=n; j++){
                if(i*j<=mid){
                    kValue++;
                }
            }
        }
        return kValue>=k;
    }
    public int findKthNumber(int m, int n, int k) {
        int left=1;
        int right = m*n;
        if(m==1 && n==1 && k==1) return 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(possible(m, n, mid, k)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// still this is taking time, optimise it further!

//  3. Optimise the for loop 
for(int i=1; i <= m; i++){
    for(int j=1; j <=n; j++){
        if(i*j<=mid){
            kValue++;
        }
    }
}

// 4. we can use this concept of traversing back from last to find the first time we find our expected output, and we don't need to calculate further for smaller values
while(j>0 && j*i>mid)j--;
*/
