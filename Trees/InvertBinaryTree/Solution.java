/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity O(V + E);
// Space Complexity O(V + E);
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Time O(V + E)
        // Space O(V + E)
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode helper = root.left;
        root.left = root.right;
        root.right = helper;

        return root;
    }
}