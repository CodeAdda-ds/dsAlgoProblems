class Solution {
    public int numTrees(int n) {
        int[] a= new int[n+1];
        a[0]=1;
        a[1]=1;
        for(int i=2;i<=n;i++)
        {
            a[i]=0;
            for(int j=1;j<=i;j++)
            {
                a[i] = a[j-1]*a[i-j]+a[i];
            }
        }
        return a[n];
    }
}