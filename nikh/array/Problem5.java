//TC = O(log(n+m))
//https://www.youtube.com/watch?v=LPFhl65R7ww&t=1s

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int i=0,j=0;
//         int n =nums1.length;
//         int m =nums2.length;
//         int[] nums3 = new int[n+m];
//         int l=0;
//         while(i<n && j<m)
//         {
//             if(nums1[i]>nums2[j])
//             {
//                 nums3[l++]=nums2[j];
//                 j++;
//             }
//             else{
//                 nums3[l++]=nums1[i];
//                 i++;
//             }
//         }
        
//         while(i<n)
//         {
//             nums3[l++]=nums1[i];
//             i++;
//         }
        
//         while(j<m)
//         {
//             nums3[l++]=nums2[j];
//                 j++;
//         }
//         double ans;
//         int len = nums3.length;
        
//         if(len%2!=0)
//         {
//             ans = nums3[len/2];
//         }
//         else{
//             ans = nums3[len/2]+nums3[(len/2)-1];
//             ans = ans/2;
//         }
        
//         return ans;
        
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        int n = nums1.length;
        int m = nums2.length;
        double ans=0;
        int low = 0, high = n;
        while(low<=high)
        {
            int pX = (low+high)/2;
            int pY = (n+m+1)/2 - pX;
            
            int maxLX = (pX==0) ? Integer.MIN_VALUE : nums1[pX-1];
            int minRX = (pX==n) ? Integer.MAX_VALUE : nums1[pX];
            
            int maxLY = (pY==0) ? Integer.MIN_VALUE : nums2[pY-1];
            int minRY = (pY==m) ? Integer.MAX_VALUE : nums2[pY];
            
            if(maxLX<=minRY && maxLY<=minRX)
            {
                int len = n+m;

                if(len%2!=0)
                {
                    ans = Math.max(maxLX,maxLY);
                
                }
                else{
                    ans = Math.max(maxLX,maxLY)+Math.min(minRX,minRY);
                    ans = ans/2;
                   
                }
               break;
            }
            
            else if(maxLX>minRY){
                high = pX-1;
            }
            else{
                low = pX+1;
            }
            
        }
        return ans;
    }
}
