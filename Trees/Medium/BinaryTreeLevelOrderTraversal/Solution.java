package Trees.Medium.BinaryTreeLevelOrderTraversal;

// Question link: https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currArr = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            // Re-start the array for a new level.
            currArr = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode curr = queue.remove();
                currArr.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(currArr);
        }

        return result;
    }
}