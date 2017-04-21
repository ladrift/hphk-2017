package oj.lintcode.BinaryTree;

/**
 * A node of binary tree from LintCode.
 *
 * @author Ziyi Yan <cxfyzy@gmail.com>
 *         Created on 18/04/2017.
 */
public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}