package org.meng.letcode.day02;

/**
 * @author meng
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * @param root 二叉树根
     * @param p    节点1
     * @param q    节点2
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val <= p.val && root.val <= q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
