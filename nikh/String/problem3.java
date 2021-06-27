class Solution {
    public int lengthOfLongestSubstring(String s) {
        int out=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0,r=0;
        for(r=0;r<s.length();r++)
        {
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)),l);
            }
            map.put(s.charAt(r),r+1);
            out = Math.max(out,r-l+1);
        }
        return out;
    }
}