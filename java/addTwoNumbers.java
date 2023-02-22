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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //All the variables needed
        
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;

        while (p != null || q != null){
            //Two variables for storing numbers in p&q and also help, 
            //if the length is mismatched
            // This mean if p is not null, then p.value else 0
            int x = p!=null ? p.val : 0;
            int y = q!=null ? q.val : 0;

            //Sum
            int sum = x + y + carry;
            carry = sum/10;
            //Creating new node to attact to our cuurent node
            curr.next = new ListNode(sum%10);

            //Shifting the nodes of all the pointers
            curr = curr.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        //Maintaing the carry 
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}