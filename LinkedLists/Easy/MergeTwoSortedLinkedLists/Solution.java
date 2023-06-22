package LinkedLists.Easy.MergeTwoSortedLinkedLists;

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

// Question link: https://leetcode.com/problems/merge-two-sorted-lists/

// Time Complexity O(n)
// Space Complexity O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }

        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        return dummyNode.next;
    }
}