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
        ListNode dummyHead = new ListNode(0); //Initialize present node to dummy head to return list
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0; // Initialize carry to 0 ;  Carry can be 0 or 1 only (9+9+1 = 19); 
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0; //Set x to node's p value. If p has reached the end of l1, set to 0.
            int y = (q != null) ? q.val : 0; //Set y to node's q value. If q has reached the end of l2, set to 0.
            int sum = carry + x + y; 
            carry = sum / 10;
            curr.next = new ListNode(sum % 10); //Create a new node with the digit value (sum mod 10) and set it to curr                                                 //node's next, then advance current node to next;
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) { //If carry = 1, append a new node with digit 1 to returning list;
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}