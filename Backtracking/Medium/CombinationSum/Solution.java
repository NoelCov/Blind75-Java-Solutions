// Question link: https://leetcode.com/problems/combination-sum/

class Solution {
    // Time Complexity O(2 ^ n)
    // Space Complexity O(2 ^ n * n)
    // Because in the worst case, every combination is valid
    // and each combination could have a length of n.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(target, 0, candidates, curr, res);
        return res;
    }

    public void backtrack(int target, int idx, int[] candidates, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
        } else if (target < 0) {
            return;
        } else {
            for (int i = idx; i < candidates.length; i++) {
                curr.add(candidates[i]);
                backtrack(target - candidates[i], i, candidates, curr, res);
                // Remove the last element that was added.
                curr.remove(curr.size() - 1);
            }
        }
    }
}