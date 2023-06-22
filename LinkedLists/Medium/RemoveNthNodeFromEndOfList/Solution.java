package LinkedLists.Medium.RemoveNthNodeFromEndOfList;

// Question link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Time O(n)
        // Space O(1)

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n + 1 times to create a distance between slow and fast
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow at the same time
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Slow is now at the node before the one we need to remove
        // Set slow.next to slow.next.next to eliminate the Nth node from the end of the
        // list.
        slow.next = slow.next.next;

        return dummy.next;
    }
}