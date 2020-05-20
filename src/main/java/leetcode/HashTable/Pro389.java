package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-03 22:48
 **/
public class Pro389 {

    public char findTheDifference(String s, String t) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        System.out.println(map);
        for(int i = 0; i < t.length(); i++) {
            String temp = t.substring(i, i + 1);
            if (!map.containsKey(temp)) {
                return t.charAt(i);
            }
            map.put(temp, map.get(temp) - 1);
        }

        System.out.println(map);

        char res = t.charAt(0);
        for(Map.Entry<String, Integer> item: map.entrySet()) {
            if (item.getValue() < 0) {
                res = item.getKey().charAt(0);
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Pro389 pro = new Pro389();
        System.out.println(pro.findTheDifference("abced", "abcded"));
    }
}
