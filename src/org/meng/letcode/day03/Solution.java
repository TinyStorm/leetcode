package org.meng.letcode.day03;

import com.sun.deploy.panel.ExceptionListDialog;

import java.util.HashSet;
import java.util.Set;

/**
 * @author meng
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring2("pwwkew"));
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     * <p>
     * 示例1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int cursor = 0;
        Set<Character> characters = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!characters.contains(current)) {
                characters.add(current);
                max++;
            } else {
                cursor = s.indexOf(current, cursor) + 1;
                int tmp = lengthOfLongestSubstring(s.substring(cursor));
                if (max < tmp) {
                    max = tmp;
                }
                break;
            }
        }
        return max;

    }

    /**
     * 递归解法太垃圾
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int cursor = 0;
        int max = 0;
        int tmp = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            while (set.contains(cha) && cursor < i) {
                set.remove(s.charAt(cursor));
                cursor++;
                tmp--;
            }
            set.add(cha);
            tmp++;
            max = Math.max(tmp, max);
        }
        return max;

    }
}
