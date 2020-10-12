package org.meng.letcode.day04;

/**
 * @author Meng
 */
public class Solution {
    int cursor = -1;
    int diff = Integer.MAX_VALUE;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(236);
        TreeNode root1 = root.left = new TreeNode(104);
        TreeNode root2 = root.right = new TreeNode(701);
        root1.right = new TreeNode(227);
        root2.right = new TreeNode(911);
        System.out.println(new Solution().getMinimumDifference(root));

    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diff;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if (cursor != -1) {
            int currentDiff = Math.abs(cursor - root.val);
            if (currentDiff < diff) {
                diff = currentDiff;
            }
        }
        cursor = root.val;
        if (root.right != null) {
            dfs(root.right);
        }

    }

    /**
     * 获取最大绝对值
     *
     * @param root
     * @param max
     * @param min
     * @return
     */
    public int getMaximumDifference(TreeNode root, int max, int min) {
        if (root.left != null) {
            return getMaximumDifference(root.left, max, min);
        } else if (root.right != null) {
            return getMaximumDifference(root.right, max, min);
        } else {
            if (root.val > max) {
                max = root.val;
            }
            if (root.val < min) {
                min = root.val;
            }
            return max - min;
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
