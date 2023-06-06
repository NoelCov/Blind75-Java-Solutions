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

// Time Complexity O(V + E)
// Space Complexity O(V + E)
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        // When going down, always check if the val is equal to start checking if it's
        // same tree.
        if (root.val == subRoot.val) {
            // Only return true here bc otherwise it'll stop checking the rest of the tree
            // if it's false.
            boolean res = isSameTree(root, subRoot);
            if (res) {
                return true;
            }
        }
        // If one of them was true, return true.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Previous problem 'Same Tree'
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}