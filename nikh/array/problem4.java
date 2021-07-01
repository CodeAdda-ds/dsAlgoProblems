/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n=intervals.size();
        ArrayList<Interval> out = new ArrayList<>(n+1);
        if(n==0)
        {
            out.add(newInterval);
            return out;
        }
        if (newInterval.end < intervals.get(0).start ||
            newInterval.start > intervals.get(n-1).end)
    {
        if (newInterval.end < intervals.get(0).start)
            out.add(newInterval);
 
        for (int i = 0; i < n; i++)
            out.add(intervals.get(i));
 
        if (newInterval.start > intervals.get(n-1).end)
            out.add(newInterval);
 
        return out;
    }
        for(int i=0;i<n;i++)
        {
            Interval temp = intervals.get(i);
            if(newInterval.start>=temp.start && newInterval.start<=temp.end)
            {
                out.add(new Interval(Math.min(newInterval.start,temp.start),Math.max(newInterval.end,temp.end)));
            }
            else if(temp.start>=newInterval.start && temp.start<=newInterval.end)
            {
                out.add(new Interval(Math.min(newInterval.start,temp.start),Math.max(newInterval.end,temp.end)));
            }
            else{
                out.add(new Interval(temp.start,temp.end));
                if(i+1<n){
                if(newInterval.end<intervals.get(i+1).start && temp.end<newInterval.start)
                    out.add(new Interval(newInterval.start,newInterval.end));}
            }
        }
        ArrayList<Interval> ans = new ArrayList<>();
        Interval temp = out.get(0);
        
        for(int i=0;i<out.size()-1;i++)
        {
            if(temp.end<out.get(i+1).start){
                ans.add(new Interval(temp.start,temp.end));
                temp.start = out.get(i+1).start;
                temp.end = out.get(i+1).end;
            }
            else if(temp.end>=out.get(i+1).start)
            {
                temp.start = Math.min(temp.start,out.get(i+1).start);
                temp.end = Math.max(temp.end,out.get(i+1).end);
            }
        }
        ans.add(new Interval(temp.start,temp.end));
        return ans;
    }
}
