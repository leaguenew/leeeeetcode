package leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-14 13:50
 **/
public class Pro438 {

    private List<Integer> resList = new ArrayList<>();
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return resList;
        }
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int[] bitS = new int[26];
        int[] bitP = new int[26];
        for(int i = 0; i < charP.length; i++) {
            bitS[charS[i] - 'a']++;
            bitP[charP[i] - 'a']++;
        }
        if (match(bitS, bitP)) {
            resList.add(0);
        }
        for(int i = 1; i <= charS.length - charP.length; i++) {
            bitS[charS[i + charP.length - 1] - 'a']++;
            bitS[charS[i - 1] - 'a']--;
            if (match(bitS, bitP)) {
                resList.add(i);
            }
        }

        return resList;
    }

    private boolean match(int[] bit1, int[] bit2) {
        for(int i = 0; i < bit1.length; i++) {
            if (bit1[i] != bit2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Pro438 pro = new Pro438();
        System.out.println(pro.findAnagrams("cbaebabacd", "abc"));
    }
}
