class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        int[] map = new int[n];
        ArrayList<Integer> narr = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++)
        {
            map[arr[i]]++;
        }
        for(int i=0;i<map.length;i++)
        {
            if(map[i]>1)
            {
                narr.add(i);
                map[i]=0;
            }
        }
        if(narr.size()==0)
            narr.add(-1);
        return narr;
    }
}