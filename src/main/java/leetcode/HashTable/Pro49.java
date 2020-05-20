package leetcode.HashTable;

import java.util.*;

public class Pro49 {

    private Map<String, List<String>> map = new HashMap<String, List<String>>();

    private List<List<String>> resList = new ArrayList<List<String>>();

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return resList;
        }

        for(String str: strs) {
            char[] chars = str.toCharArray();//string to chars

            Arrays.sort(chars);//sort chars

            String sortedStr = String.valueOf(chars);//chars to string

            List<String> listTmp = map.get(sortedStr);;
            if (listTmp == null) {
                listTmp = new ArrayList<String>();
                listTmp.add(str);
                map.put(sortedStr, listTmp);
            } else {
                listTmp.add(str);
                map.put(sortedStr, listTmp);
            }
        }

        for(Map.Entry<String, List<String>> item : map.entrySet()) {
            resList.add(item.getValue());
        }

        return resList;
    }

    public static void main(String[] args) {
        Pro49 pro = new Pro49();

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(pro.groupAnagrams(strs));
    }
}
