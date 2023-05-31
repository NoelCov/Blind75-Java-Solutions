/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time Complexity O(n)
// Space Complexity O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while (fast != null) {
            ListNode next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }

        return slow;
    }

    class ListNode {
        private int value;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.value = val;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }
}
