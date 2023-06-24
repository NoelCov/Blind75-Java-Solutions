package Trees.Medium.KthSmallestElementInABST;

// Question link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

class Solution {
    // Time Complexity O(V + E)
    // Space Complexity O(V + E)
    int counter = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    public void helper(TreeNode curr, int k) {
        if (curr == null) {
            counter++;
            return;
        }

        helper(curr.left, k);

        if (counter == k) {
            result = curr.val;
        }

        helper(curr.right, k);
    }
}