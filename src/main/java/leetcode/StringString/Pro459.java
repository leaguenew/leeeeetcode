package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-04 17:15
 **/
public class Pro459 {

    public boolean repeatedSubstringPattern(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }

        int len = s.length();
        for(int i = 0; i < len / 2; i++) {
            int lenTmp = i + 1;
            if (len % lenTmp != 0) {
                continue;
            } else {
                int count = len / lenTmp;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < count; j++) {
                    sb.append(s.substring(0, lenTmp));
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
