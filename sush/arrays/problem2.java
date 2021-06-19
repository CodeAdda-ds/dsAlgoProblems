

Question link: https://www.interviewbit.com/problems/merge-intervals/ 





public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        } else if (intervals==null){
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        Interval toInsert = newInterval;

        int i=0;
        while(i < intervals.size()){
            Interval currInterval = intervals.get(i);

            // case I when we haven't reached the interval where we need to insert 
            if(currInterval.end < toInsert.start){
                i++;
                continue;           
            } 
            // case three when we have completely passed the interval toInsert 
            else if(currInterval.start > toInsert.end){
                intervals.add(i, toInsert);
                break;
            } 
            // case two where we dealt with four cases of overlapping
            else {
                toInsert.start = Math.min(toInsert.start, currInterval.start);
                toInsert.end = Math.max(toInsert.end, currInterval.end);
                intervals.remove(i);
            }
        }
        
        if(i==intervals.size()){
            intervals.add(toInsert);
        }
        return intervals;
    }
}

