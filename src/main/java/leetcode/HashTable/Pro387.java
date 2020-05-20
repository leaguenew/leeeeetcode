package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro387 {

    public int firstUniqChar(String s) {

        if (null == s || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        char[] chars = s.toCharArray();
        for(char c : chars) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for(int i = 0 ; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Pro387 pro = new Pro387();

        String s = "loveleetcode";

        System.out.println(pro.firstUniqChar(s));
    }
}
