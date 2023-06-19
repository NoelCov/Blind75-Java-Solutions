// Question link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    // Space Complexity O(1)
    // Time Complexity O(log n)
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            // If this is true (which in a non-rotated array it wouldn't, then we know our
            // pivot is on the right side).
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                // Meaning that it is not, then it's a non-rotated array or simply the pivot is
                // on the left side.
                right = middle;
            }
        }

        // At the end both pointers will be at the pivot so we can return whichever.
        return nums[left];
    }
}