package Trees.Medium.LowestCommonAncestorOfABinarySearchTree;

// Question link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

class Solution {
    // This problem is very easy only because it's a BST.
    // In a Binary Search Tree everything to the left of a given node is smaller
    // than its value
    // And everything to the right of a given node is bigger than it's value.

    // Given this property, it's very easy to come up with a working solution.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}