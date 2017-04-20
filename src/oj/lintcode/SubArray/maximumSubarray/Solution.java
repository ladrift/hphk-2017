package oj.lintcode.SubArray.maximumSubarray;

/**
 * <h1>Binary Tree Level Order Traversal II</h1>
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * <p>
 * Source: http://lintcode.com/en/problem/maximum-subarray/
 *
 * @author Ziyi Yan <cxfyzy@gmail.com>
 *         Created on 18/04/2017.
 */
public class Solution {

    /**
     * @param nums A list of integers
     * @return An integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr < 0) {
                curr = 0;
            }
            curr += nums[i];
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }
}