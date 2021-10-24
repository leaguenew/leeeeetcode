package leetcode.HashTable;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Pro290 {

    public boolean wordPattern(String pattern, String str) {

        if (null == str || str.length() == 0) {
            return false;
        }

        String[] strArr = str.split("\\s+");

        if (pattern.length() != strArr.length) {
            return false;
        }

        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map1 = new HashMap<String, String>();

        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            String strTmp = pattern.substring(i, i + 1);
            map.put(strTmp, strArr[i]);
            map1.put(strArr[i], strTmp);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(map.get(pattern.substring(i, i + 1))).append(" ");
            sb1.append(map1.get(strArr[i]));
        }

        if (sb.toString().substring(0, sb.length() - 1).equals(str) && sb1.toString().equals(pattern)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Pro290 pro = new Pro290();

        String pattern = "";
        String str = "jquery";

        System.out.println(pro.wordPattern(pattern, str));
    }
}
