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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (odd.next != null && even.next != null) {
            // System.out.println("[odd] connecting " + odd.val + " to " + even.next.val);
            odd.next = even.next;
            odd = odd.next;
            // System.out.println("[even] connecting " + even.val + " to " + odd.next.val);
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        // System.out.println("connecting " + odd.val + " to " + evenHead.val);
        return head;
    }
}