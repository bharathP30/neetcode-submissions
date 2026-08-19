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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow1 = head;

        while( fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow1 = slow1.next;
            if( fast == slow1 ) return true;
        }

        return false;
    }
}
