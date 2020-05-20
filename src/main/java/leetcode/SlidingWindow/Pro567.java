package leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * 思路一：先算出s1所有的排列，然后跟s2匹配，超时
 * 思路二：滑动窗口 + 词频统计，保持一个长度为s1.length的滑动窗口，然后统计
 * @author: niuliguo
 * @create: 2020-02-13 17:23
 * @company: ByteDance
 **/
public class Pro567 {

    private List<String> permutation = new ArrayList<>();
    private int len;
    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        len = s1.length();
        backtracing("", s1);
        for (String str : permutation) {
            if (s2.contains(str)) {
                return true;
            }
        }

        return false;
    }

    private void backtracing(String cur, String left) {
        System.out.println("cur = " + cur + ", left = " + left);
        if (cur.length() == len) {
            permutation.add(cur);
            return;
        }

        for(int i = 0; i < left.length(); i++) {

            backtracing(cur + left.substring(i, i + 1),
                    i == 0 ? left.substring(1, left.length()) : left.substring(0, i) + left.substring(i + 1, left.length()));
        }
    }

    public boolean checkInclusion1(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] bits1 = new int[26];
        int[] bits2 = new int[26];
        for(int i = 0; i < chars1.length; i++) {
            bits1[chars1[i] - 'a']++;
            bits2[chars2[i] - 'a']++;
        }
        if (match(bits1, bits2)) {
            return true;
        }

        for(int i = 1; i <= chars2.length - chars1.length; i++) {
            bits2[chars2[i + chars1.length - 1] - 'a']++;
            bits2[chars2[i - 1] - 'a']--;
            if (match(bits1, bits2)) {
                return true;
            }
        }

        return false;
    }

    private boolean match(int[] bits1, int[] bits2) {
        for(int i = 0; i < bits1.length; i++) {
            if (bits1[i] != bits2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Pro567 pro = new Pro567();
//        System.out.println(pro.checkInclusion("abcdxabcde","abcdeabcdx"));
//        System.out.println(pro.checkInclusion1("abcdxabcde","abcdeabcdx"));
//        System.out.println(pro.checkInclusion1("bd", "eidboaoo"));
        System.out.println(pro.checkInclusion1("ccc", "cbac"));
    }
}
