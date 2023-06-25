import java.util.Arrays;
import javax.swing.tree.TreeNode;

// Question link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // When we no longer have anything in the lists, we are done with the current
        // subtree so .next should be null.
        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }

        // The preorder[0] will be the root node (because preorder goes
        // from root, to left, to right)
        TreeNode root = new TreeNode(preorder[0]);

        // We then get the index of where the root.value is in preorder to know where to
        // divide the arrays
        int point = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                point = i;
                break;
            }
        }

        // We will pass the left side of both arrays to root.left (because all the
        // values will go on the left) Because in-order goes from left node, to parent
        // node to right node.
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, point + 1),
                Arrays.copyOfRange(inorder, 0, point));

        // We will pass the right side of both arrays to root.right (same reason)
        // We know this because of how inorder and preorder work.
        root.right = buildTree(
                Arrays.copyOfRange(preorder, point + 1, preorder.length),
                Arrays.copyOfRange(inorder, point + 1, inorder.length));

        // At the end return the root which will return the current value every time
        // and in the end everything will be connected and thus we'll return the head of
        // our new tree.
        return root;
    }
}