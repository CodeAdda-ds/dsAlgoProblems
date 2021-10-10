class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(numRows);
        List<Integer> currRow;
        List<Integer> prevRow = null;
        for(int i=0; i < numRows; i++){
            currRow = new ArrayList<>(i+1); // because every row has that much elements
            for(int j=0; j < i+1; j++){
                if(j==0 || j==i){
                    currRow.add(1);
                } else {
                    currRow.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            prevRow = currRow;
            ans.add(currRow);
        }
        return ans;
    }
}


/*
Points to remember:
here the general function , f(n, i) = f(n-1, i-1) + f(n-1, i)
since we are adding of n-1, we can use prev so that prev array is stored and can be used

*/


// Pascal triangle, different problem:

// https://leetcode.com/problems/pascals-triangle-ii/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>(rowIndex+1);
        for(int i=0; i < rowIndex+1; i++){
            ans.add(1); // last wala 1 represent karta hai ye 1, not first
            for(int j=i-1; j > 0; j--){
                ans.set(j, ans.get(j) + ans.get(j-1)); // way to set values in array list
            }
        }
        return ans;
    }
}



/*
Points to remember:
1.  arr[j] = arr[j] + arr[j-1] iska equivalent
    arr.set(j, arr.get(j) + arr.get(j-1))

2. Logic:
whenever i is increased, we add(1) 
that is for last wala 1
first wala 1 change nahi hoga kyoki j > 0

k == 0
[1] 
k == 1
[11] 
k == 2
[111]  add 1
[121]  calculate jth spot
k == 3
[1211]  add 1
[1331]   calculate jth spot
k == 4
[13311]  add 1
[14641]  calculate jth spot

3. Instead of saving the previous array by taking extra space, i se reverse back karo traverse aur add karte jao

*/


