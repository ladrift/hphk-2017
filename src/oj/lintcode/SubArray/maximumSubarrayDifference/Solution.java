package oj.lintcode.SubArray.maximumSubarrayDifference;

import java.util.Arrays;

/**
 * <h1>Maximum Subarray Difference</h1>
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 *
 * @author Ziyi Yan <cxfyzy@gmail.com>
 *         Created on 20/04/2017.
 */
public class Solution {
    /**
     * @param nums A list of integers
     * @return An integer indicate the value of maximum difference between two subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] leftMax = new int[size];
        int[] leftMin = new int[size];
        int[] rightMax = new int[size];
        int[] rightMin = new int[size];

        int[] negativeCopy = new int[size];
        for (int i = 0; i < size; i++) {
            negativeCopy[i] = -nums[i];
        }

        // Maximum sum from left
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < size; i++) {
            curr = Math.max(0, curr) + nums[i];
            max = Math.max(curr, max);
            leftMax[i] = max;
        }
        // Maximum sum from right
        max = Integer.MIN_VALUE;
        curr = 0;
        for (int i = size - 1; i >= 0; i--) {
            curr = Math.max(0, curr) + nums[i];
            max = Math.max(curr, max);
            rightMax[i] = max;
        }
        // Minimum sum from left
        max = Integer.MIN_VALUE;
        curr = 0;
        for (int i = 0; i < size; i++) {
            curr = Math.max(0, curr) + negativeCopy[i];
            max = Math.max(curr, max);
            leftMin[i] = -max;
        }
        // Minimum sum from right
        max = Integer.MIN_VALUE;
        curr = 0;
        for (int i = size - 1; i >= 0; i--) {
            curr = Math.max(0, curr) + negativeCopy[i];
            max = Math.max(curr, max);
            rightMin[i] = -max;
        }

        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(leftMax[i] - rightMin[i + 1], diff);
            diff = Math.max(rightMax[i + 1] - leftMin[i], diff);
        }

        return diff;
    }

    public static void main(String[] args) {
        int result = new Solution().maxDiffSubArrays(new int[]{-5, -4});
        System.out.println("result = " + result);

        result = new Solution().maxDiffSubArrays(new int[]{1, 2, -3, 1});
        System.out.println("result = " + result);
    }
}