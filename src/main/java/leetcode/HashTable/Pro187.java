package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro187 {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new ArrayList<String>();

        if (s == null || s.length() <= 10) {
            return list;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0 ; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (map.get(str) == null) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str).intValue() + 1);
            }
        }

        for(Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() > 1) {
                list.add(item.getKey());
            }
        }

        return list;
    }

    public static void main(String[] args) {

        Pro187 pro = new Pro187();

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> list = pro.findRepeatedDnaSequences(s);

        System.out.println(list);
    }
}
