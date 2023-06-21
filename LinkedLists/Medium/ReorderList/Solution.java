package LinkedLists.Medium.ReorderList;

// Question link: https://leetcode.com/problems/reorder-list/

class Solution {
    // Time Complexity O(n)
    // Space Complexity O(1)

    public void reorderList(ListNode head) {
        // Step 1. Reverse half the linkedlist
        // Step 2. Reorder
        ListNode slow = head;
        ListNode fast = head;

        // Find midpoint of linkedlist.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // We reposition fast
        ListNode curr = slow;
        ListNode prev = null;

        // Reversing
        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Slow is at the end of ll.
        // Use 2 pointer approach.
        ListNode left = head;
        ListNode right = prev;

        // Reorder
        while (right.next != null) {
            ListNode nextLeft = left.next; // 3
            ListNode nextRight = right.next; // null

            left.next = right;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }
}