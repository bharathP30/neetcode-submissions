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
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: move prev to node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: reverse sublist
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode sublistPrev = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = sublistPrev;
            sublistPrev = curr;
            curr = next;
        }

        // Step 3: reconnect
        prev.next.next = curr;   // tail of reversed sublist points to node after 'right'
        prev.next = sublistPrev; // prev points to new head of reversed sublist

        return dummy.next;
    }
}
