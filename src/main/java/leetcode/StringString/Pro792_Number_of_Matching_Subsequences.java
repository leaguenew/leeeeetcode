package leetcode.StringString;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-05-04 17:05
 **/
public class Pro792_Number_of_Matching_Subsequences {

    public int numMatchingSubseq(String S, String[] words) {
        if (null == words || words.length == 0) {
            return 0;
        }

        Map<String, Integer> str2cnt = new HashMap<>();

        int cnt = 0;
        for(int i = 0; i < words.length; i++) {
            str2cnt.put(words[i], str2cnt.getOrDefault(words[i], 0) + 1);
        }

        for(String str : str2cnt.keySet()) {
            if (isSubsequence(str, S)) {
                cnt += str2cnt.get(str);
            }
        }

        return cnt;
    }

    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null || t.length() < s.length()) {
            return false;
        }

        int idxS = 0;
        int idxT = 0;
        int lenS = s.length();
        int lenT = t.length();
        while(idxS < lenS && idxT < lenT) {
            while (idxT < lenT && s.charAt(idxS) != t.charAt(idxT)) {
                idxT++;
            }

            if (idxT == lenT) {
                break;
            }

            idxS++;
            idxT++;
        }

        return idxS == lenS;
    }
}
