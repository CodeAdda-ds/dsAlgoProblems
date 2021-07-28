/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



// this solution does not work for large integers, so we need to find a solution without calculating the whole sum
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1=0;
        int sum2=0;
        int multiplier1 = 1;
        int multiplier2 = 1;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1!=null){
            sum1 += multiplier1*temp1.val;
            multiplier1 *= 10;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            sum2 += multiplier2*(temp2.val);
            multiplier2 *= 10;
            temp2 = temp2.next;
        }
        int totalSum = sum1 + sum2;  
        int element = totalSum%10;
        totalSum /= 10;
        ListNode output = new ListNode(element);
        ListNode prev = output;
        while(totalSum>0){
            element = totalSum%10;
            totalSum /= 10;
            ListNode current = new ListNode(element);
                prev.next = current;
                prev = current;
            }
        return output;
        }   
    }


// this is the final solution
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstPointer = l1, secPointer = l2;
        ListNode output = null, traverseOutput = null;
        int sum, carry = 0;
        while(firstPointer!=null && secPointer!=null){
            sum = firstPointer.val + secPointer.val + carry;
            if(output==null){
                output = new ListNode(sum%10);
                traverseOutput = output;
            } else {
                traverseOutput.next = new ListNode(sum%10);
                traverseOutput = traverseOutput.next;

            }
            carry = sum/10;
            firstPointer = firstPointer.next;
            secPointer = secPointer.next;
        }
        while(firstPointer!=null){
            sum = firstPointer.val + carry;
            traverseOutput.next = new ListNode(sum%10);
            traverseOutput = traverseOutput.next;
            carry = sum/10;
            firstPointer = firstPointer.next;
        }
        while(secPointer!=null){
            sum = secPointer.val + carry;
            traverseOutput.next = new ListNode(sum%10);
            traverseOutput = traverseOutput.next;
            carry = sum/10;
            secPointer = secPointer.next;
        }
        if(carry!=0){
            traverseOutput.next = new ListNode(carry);
        }
        return output;
    }   
}

