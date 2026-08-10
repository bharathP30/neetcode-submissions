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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode center = findCenter(head);
        ListNode secondHead = reverseList(center);
        center.next = null;

        mergeAlternately(head, secondHead);
    }

    public ListNode findCenter(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode start){
        ListNode prev = null;
        ListNode curr = start.next;

        while ( curr != null ){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void mergeAlternately(ListNode firstHead, ListNode secondHead){
        
        while( secondHead != null ){
           ListNode tmp1 = firstHead.next;
            ListNode tmp2 = secondHead.next;
            firstHead.next = secondHead;
            secondHead.next = tmp1;
            firstHead = tmp1;
            secondHead = tmp2;
        }
    }
}
