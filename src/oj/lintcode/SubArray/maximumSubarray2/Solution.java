package oj.lintcode.SubArray.maximumSubarray2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h1>Maximum Sub-array II</h1>
 * Given an array of integers, find two non-overlapping sub-arrays which have the largest sum.
 * The number in each sub-array should be contiguous.
 * Return the largest sum.
 * <p>
 * Source: http://lintcode.com/en/problem/maximum-subarray-ii/
 *
 * @author Ziyi Yan <cxfyzy@gmail.com>
 *         Created on 18/04/2017.
 */
public class Solution {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int leftCurr = nums.get(0);
        int leftMax = leftCurr;
        int[] leftMaxs = new int[nums.size()];
        leftMaxs[0] = leftMax;
        for (int i = 1; i < nums.size(); i++) {
            if (leftCurr < 0) {
                leftCurr = 0;
            }
            leftCurr += nums.get(i);
            if (leftCurr > leftMax) {
                leftMax = leftCurr;
            }
            // leftMaxs[i] equals to the max subarray sum when array is [0, i]
            leftMaxs[i] = leftMax;
        }

        int rightCurr = nums.get(nums.size() - 1);
        int rightMax = rightCurr;
        int twoArrayMax = leftMaxs[nums.size() - 2] + rightMax;
        for (int i = nums.size() - 1 - 1; i > 0; i--) {
            if (rightCurr < 0) {
                rightCurr = 0;
            }
            rightCurr += nums.get(i);
            if (rightCurr > rightMax) {
                rightMax = rightCurr;
            }

            if (leftMaxs[i - 1] + rightMax > twoArrayMax) {
                twoArrayMax = leftMaxs[i - 1] + rightMax;
            }
        }
        return twoArrayMax;
    }

    public static void main(String[] args) {
        int result = new Solution().maxTwoSubArrays(new ArrayList<Integer>(Arrays.asList(-4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -1000)));
        System.out.println("result = " + result);
    }
}