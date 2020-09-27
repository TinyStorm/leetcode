package org.meng.letcode.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meng
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{1, 3, 5, 9}, 10)));

        System.out.println(7 % 10);
        System.out.println(Long.MAX_VALUE);

        ListNode l1 = new ListNode(2);
        l1.addNode(4).addNode(3);
        ListNode l2 = new ListNode(5);
        l2.addNode(6).addNode(4);
//        l2.addNode(6).addNode(4);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(new Solution().addTwoNumbers2(l1, l2));


    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * Example 1:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * <p>
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * <p>
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     * <p>
     * Constraints:
     * 2 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("no answer");
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
     * [5,6,4]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> numList = new ArrayList<>();
        ListNode l = l1;
        numList.add(l.val);
        while ((l = l.next) != null) {
            numList.add(l.val);
        }
        long num1 = 0;
        long times = 1;
        for (long value : numList) {
            num1 += value * times;
            times *= 10;
        }
        numList.clear();
        l = l2;
        numList.add(l.val);
        while ((l = l.next) != null) {
            numList.add(l.val);
        }
        long num2 = 0;
        times = 1;
        for (long integer : numList) {
            num2 += integer * times;
            times *= 10;
        }
        long sum = num1 + num2;
        ListNode res = new ListNode((int) (sum % 10L));
        sum /= 10;
        ListNode tmp = res;
        while (sum > 0) {
            tmp.next = new ListNode((int) (sum % 10L));
            tmp = tmp.next;
            sum /= 10;
        }

        return res;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0), current = result;
        while (l1 != null || l2 != null || carry > 0) {
            int i = 0;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            int j = 0;
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            int sum = i + j + carry;

            carry = sum / 10;
            sum = carry > 0 ? sum % 10 : sum;
            current.next = new ListNode(sum);
            current = current.next;
        }

        return result.next;


    }

    public ListNode reverse(ListNode listNode) {
        ListNode current = listNode;
        ListNode before = null;
        while (current.next != null) {
            ListNode tmp = current;
            current = tmp.next;
            tmp.next = before;
            before = tmp;
        }
        current.next = before;
        return current;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode addNode(int val) {
            ListNode next = new ListNode(val);
            this.next = next;
            return next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(this.val));
            ListNode l = this;
            while ((l = l.next) != null) {
                sb.append("->").append(l.val);
            }
            return sb.toString();
        }
    }
}
