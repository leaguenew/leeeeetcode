package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description: check if s is subsequence of t, s < t
 * @author: niuliguo
 * @create: 2020-05-04 16:43
 **/
public class Pro392_Is_Subsequence {

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
