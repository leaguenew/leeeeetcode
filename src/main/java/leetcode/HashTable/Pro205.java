package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

//todo： 未写到blog；优化
public class Pro205 {

    public boolean isIsomorphic(String s, String t) {

        if (s == null && t == null || s.length() == 0 && t.length() == 0) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map1 = new HashMap<String, String>();

        for(int i = 0 ; i < s.length(); i++) {
            String key = s.substring(i, i + 1);
            String value = t.substring(i, i + 1);
            map.put(key, value);
            map1.put(value, key);
        }

        StringBuilder sb = new StringBuilder("");
        StringBuilder sb1 = new StringBuilder("");
        for(int i = 0 ; i < s.length(); i++) {
            sb.append(map.get(s.substring(i, i + 1)));
            sb1.append(map1.get(t.substring(i, i + 1)));
        }

        if (t.equals(sb.toString()) && s.equals(sb1.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Pro205 pro = new Pro205();

        String s = "ab";

        String t = "aa";

        System.out.println(pro.isIsomorphic(s, t));
    }
}
