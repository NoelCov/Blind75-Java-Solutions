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

// Question link: https://leetcode.com/problems/reverse-linked-list/

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
}
