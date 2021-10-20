// Problem link: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        
        ArrayList<Long> ans = new ArrayList<>();
        Deque<Long> q = new ArrayDeque<>(); // use this for queue
        int left=0;
        int right=0;
        while(right < N){
            // calculations
            if(A[right] < 0){
                q.add(A[right]);  // add karta hai simply
            }
            if(right-left+1 < K){
                right++; 
            } else if(right-left+1==K){
                // take ans from calculations and remove from queue
                if(q.isEmpty()) {
                    ans.add((long)0); // no negative number found in window
                } else {
                    ans.add(q.peek());  
                    // sliding the window
                    if(A[left]==q.peek()){  
                        q.poll();  // remove karo kyoki ans me add ho chuka hai
                    }
                }
                right++;
                left++;
            }
        }
        long[] a = new long[ans.size()];
        for(int k=0; k < ans.size(); k++){
            a[k] = ans.get(k);
        }
        return a;
    }
}


/*
Points to remember: 
1. creating a queue
Deque<Long> q = new ArrayDeque<>(); 

2. We can store the answer we find first in the window and if there is another in the same window, store it too so that later 
we can deal with it when it's part of the next window

Matlab, agar ek window me more than answers dikh rahe hain then use a queue and store the answers there and deal with
them in the next windows

*/
