class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        ListNode l3 = null, h3=null;
        int carry = 0,sum = 0;
        while(h1!= null && h2!= null)
        {
            sum = h1.val+h2.val+carry;
            if(l3==null)
            {
                l3 = new ListNode(sum%10);
                h3 = l3;
            }
            else{
                h3.next = new ListNode(sum%10);
                h3 = h3.next;
            }
            carry = sum/10;
            h1 = h1.next;
            h2 = h2.next;
        }
        while(h1!=null)
        {
            sum = h1.val+carry;
            h3.next = new ListNode(sum%10);
            carry = sum/10;
            h1 = h1.next;
            h3 = h3.next;
        }
        while(h2!=null)
        {
            sum = h2.val+carry;
            h3.next = new ListNode(sum%10);
            carry = sum/10;
            h2 = h2.next;
            h3 = h3.next;
        }
        if(carry!=0)
        {
            h3.next = new ListNode(carry);
        }
        return l3;
    }
}