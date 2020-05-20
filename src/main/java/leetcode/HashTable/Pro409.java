package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-23 22:41
 **/
public class Pro409 {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> char2cnt =  new HashMap<>();
        for(Character character: s.toCharArray()) {
            if (char2cnt.get(character) == null) {
                char2cnt.put(character, 1);
            } else {
                char2cnt.put(character, char2cnt.get(character) + 1);
            }
        }
        int cnt = 0;
        boolean left = false;
        for(Map.Entry<Character, Integer> map: char2cnt.entrySet()) {
            if (map.getValue() > 1) {
                if (map.getValue() % 2 == 0) {
                    cnt += map.getValue();
                } else {
                    cnt += map.getValue() - 1;
                    left = true;
                }
            } else {
                left = true;
            }
        }

        return  left ? cnt + 1: cnt;
    }

    public static void main(String[] args) {

    }
}
