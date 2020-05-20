package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-06 13:51
 **/
public class Pro443 {

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int l = 0, r = 0, len = chars.length, pos = 0;
        while(l < len) {
            while(r < len && chars[l] == chars[r]) {
                r++;
            }
            int dist = r - l;
            if (dist == 1) {
                chars[pos] = chars[l];
                pos++;
            } else {
                chars[pos] = chars[l];
                pos++;
                char[] distChars = String.valueOf(dist).toCharArray();
                for(int i = 0; i < distChars.length; i++) {
                    chars[pos] = distChars[i];
                    pos++;
                }
            }

            l = r;
        }

        return pos;
    }
}
