package oj.lintcode.BinaryTree.binaryTreeLevelOrderTraversal2;

import java.util.ArrayList;

import oj.lintcode.BinaryTree.TreeNode;

/**
 * <h1>Binary Tree Level Or</h1>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * Source: http://lintcode.com/zh-cn/problem/binary-tree-level-order-traversal-ii/
 *
 * @author Ziyi Yan <cxfyzy@gmail.com>
 *         Created on 18/04/2017.
 */
public class Solution {

    /**
     * @param root: The root of binary tree.
     * @return bottom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> left = levelOrderBottom(root.left);
        ArrayList<ArrayList<Integer>> right = levelOrderBottom(root.right);

        ArrayList<ArrayList<Integer>> curr = new ArrayList<>();
        curr.addAll(merge(left, right));

        ArrayList<Integer> top = new ArrayList<>();
        top.add(root.val);

        curr.add(top);
        return curr;
    }

    ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> lhs, ArrayList<ArrayList<Integer>> rhs) {
        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();
        for (int i = 0; i < lhs.size() || i < rhs.size(); i++) {
            int lhsIdx = lhs.size() - 1 - i;
            int rhsIdx = rhs.size() - 1 - i;
            final int headIndex = 0;
            if (lhsIdx < 0) {
                merged.add(headIndex, rhs.get(rhsIdx));
            } else if (rhsIdx < 0) {
                merged.add(headIndex, lhs.get(lhsIdx));
            } else {
                lhs.get(lhsIdx).addAll(rhs.get(rhsIdx));
                merged.add(headIndex, lhs.get(lhsIdx));
            }
        }
        return merged;
    }
}
