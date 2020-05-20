package leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * 解法：https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC3%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E6%97%A0%E9%87%8D%E5%A4%8D%E5%AD%97%E7%AC%A6%E7%9A%84%E6%9C%80%E9%95%BF%E5%AD%90%E4%B8%B2.md
 * 算法：双指针左右移动 + 辅助存储
 * @author: niuliguo
 * @create: 2020-02-01 22:33
 **/
public class Pro3 {


    private Map<Character, Integer> char2index = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int left = 0;
        int right = -1; //很重要
        int res = Integer.MIN_VALUE;
        while(left < len) {
            if (right + 1 < len && !char2index.containsKey(s.charAt(right + 1))) {
                char2index.put(s.charAt(right + 1), right + 1);
                right++;
            } else {  //right == len - 1 || char2index包含s.charAt(right + 1)
                int start = left;
                left = char2index.get(s.charAt(right + 1 == len ? right : right + 1)) + 1;
                int end = char2index.get(s.charAt(right + 1 == len ? right : right + 1));
                for (int i = start; i <= end; i++) {
                    char2index.remove(s.charAt(i));
                }
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Pro3 pro = new Pro3();

        String s = "abcabcbb";

        System.out.println(pro.lengthOfLongestSubstring(s));
    }
}
