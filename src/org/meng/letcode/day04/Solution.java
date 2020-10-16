package org.meng.letcode.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meng
 */
public class Solution {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new Solution().postorderTraversal2(root));
    }

    /**
     * 递归遍历算法
     *
     * @param root 根
     * @return 元素集合
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            postOrderTraversal(root, result);
        }
        return result;
    }

    /**
     * 迭代后续遍历
     * TODO 未完成
     *
     * @param root 根
     * @return 元素集合
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        boolean flag = false;
        while (true) {
            if (root != null) {
                stack.push(root);
                flag = true;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                result.add(root.val);
            }
            if (root.left != null && flag) {
                root = root.left;
            } else if (root.right != null && !flag) {
                root = root.right;
            } else {
                root = stack.pop();
                result.add(root.val);
                flag = false;
            }

        }
        return result;
    }


    /**
     * 迭代后续遍历算法
     *
     * @param root   根
     * @param result 遍历元素集合
     */
    public void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            postOrderTraversal(root.left, result);
        }
        if (root.right != null) {
            postOrderTraversal(root.right, result);
        }
        result.add(root.val);
    }


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     * <p>
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     * <p>
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     * <p>
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * <p>
     * <p>
     * 提示：
     * <p>
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -10^6 <= nums1[i], nums2[i] <= 10^6
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0L;
    }
}
