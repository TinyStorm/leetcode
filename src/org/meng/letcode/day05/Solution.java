package org.meng.letcode.day05;

import java.util.Arrays;

/**
 * @author meng
 */
public class Solution {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * 示例 1：
     * <p>
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 示例 2：
     * <p>
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A已按非递减顺序排序。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] square = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            square[i] = A[i] * A[i];
        }
        Arrays.sort(square);
        return square;
    }

    /**
     * 双指针
     *
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        int[] square = new int[A.length];
        int ci = 0;
        int cj = A.length - 1;
        int i = A.length - 1;
        while (i >= 0) {
            int di = A[ci] * A[ci];
            int dj = A[cj] * A[cj];
            if (di > dj) {
                ci++;
                square[i] = di;
            } else {
                cj--;
                square[i] = dj;
            }
            i--;
        }
        return square;
    }
}
