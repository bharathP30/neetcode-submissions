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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if( head == null ) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode tailOne = dummy;

        for( int i = 1; i < left; i++ ){ // move till left
            tailOne = tailOne.next;
        }   // now tail of the first part is right behind the "left" node

        ListNode revCurr = tailOne.next;
        ListNode next = null;
        ListNode revPrev = null;

        for( int i = left; i <= right; i++ ){ // reverse from left to right
            next = revCurr.next;
            revCurr.next = revPrev;
            revPrev = revCurr;
            revCurr = next;
        }

        // now tailOne still points to the first node of the reversed list which now should points to first node after the "right" node
        tailOne.next.next = revCurr;
        // after changing it, it should point to the last node of the reversed list
        tailOne.next = revPrev;

        return dummy.next;
    }
}
