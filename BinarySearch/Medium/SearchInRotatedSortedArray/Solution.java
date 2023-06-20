package BinarySearch.Medium.SearchInRotatedSortedArray;

// Question link: https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    // Time Complexity: O(log n)
    // Space Complexity O(1)
    public int search(int[] nums, int target) {
        // 1) Find pivot
        // 2) Do 1 cut in the middle to know which side to go to.
        // 3) Binary search

        // Find pivot
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        // Check which side to go to (split the array in half if it's rotated)
        int pivotIdx = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[pivotIdx] && target <= nums[right]) {
            left = pivotIdx;
        } else {
            right = pivotIdx - 1;
        }

        // Normal binary search
        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}