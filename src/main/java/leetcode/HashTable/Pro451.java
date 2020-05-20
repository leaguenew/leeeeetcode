package leetcode.HashTable;

import java.util.*;

public class Pro451 {

    public String frequencySort(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> mapCnt = new HashMap<Character, Integer>();
        Map<Integer, List<Character>> mapReverse = new TreeMap<Integer, List<Character>>(Collections.reverseOrder());

        for(char c : chars) {
            mapCnt.put(c, mapCnt.get(c) == null ? 1 : mapCnt.get(c) + 1);
        }

        List<Character> tmpList;
        for(Map.Entry<Character, Integer> item : mapCnt.entrySet()) {

            tmpList = mapReverse.get(item.getValue());
            if (tmpList == null) {
                tmpList = new ArrayList<Character>();
                tmpList.add(item.getKey());
                mapReverse.put(item.getValue(), tmpList);
            } else {
                tmpList.add(item.getKey());
                mapReverse.put(item.getValue(), tmpList);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, List<Character>> item : mapReverse.entrySet()) {

            int cnt = item.getKey();
            List<Character> charList = item.getValue();
            for(int i = 0; i < charList.size(); i++) {
                int cntTmp = cnt;
                while (cntTmp-- > 0) {
                    sb.append(charList.get(i));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Pro451 pro = new Pro451();

        String s = "bcaa";

        System.out.println(pro.frequencySort(s));
    }
}
