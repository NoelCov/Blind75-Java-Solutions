// Question link: https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        // // O(n ^ 2) time O(1) space.
        // int maxArea = 0;

        // for(int i = 0; i < height.length; i++) {
        // int currArea = 0;
        // for(int j = i + 1; j < height.length; j++) {
        // currArea = ((j - i) * Math.min(height[i], height[j]));
        // maxArea = Math.max(currArea, maxArea);
        // }
        // }

        // return maxArea;

        // Time Complexity O(n)
        // Space Complexity O(1)
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int currArea = ((right - left) * Math.min(leftHeight, rightHeight));

            maxArea = Math.max(currArea, maxArea);

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}