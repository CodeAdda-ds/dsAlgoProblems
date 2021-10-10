class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0],i2[0])); // sorted the array on the basis of start pointers
        
        int[] intervalToBeAdded = intervals[0];
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervalToBeAdded);
        for(int[] currInterval: intervals){
            if(currInterval[0] <= intervalToBeAdded[1]){
                intervalToBeAdded[1] = Math.max(currInterval[1], intervalToBeAdded[1]); // dynamically value change kar sakte hain arraylist ke andar ki
            } else {
                intervalToBeAdded = currInterval;
                ans.add(currInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]); // converting arraylist to array
        
    }
}


/* Points to remember: 

1. You can change the value inside the arraylist if you have stored the value through a variable
ans.add(intervalToBeAdded);
intervalToBeAdded[1] = Math.max(currInterval[1], intervalToBeAdded[1]);

2. Converting arraylist to array
ans.toArray(new int[ans.size()][]);

3. Sorting the array with comparator
Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0],i2[0]));

4. Solution logic:
we will only be changing the end pointer bcoz the start will anyway be correct as the case we are dealing with is this:

.-------.             or      .--------.   
    .---------.          .------.
    
bas current interval ka start main interval se kam/equal hona chahiye, end update kar denga

when it surpasses, simply add the current interval taki bad me uska end change kar sake if required

        .---------.
.-----.
