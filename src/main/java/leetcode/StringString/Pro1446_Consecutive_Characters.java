package leetcode.StringString;

public class Pro1446_Consecutive_Characters {

    public int maxPower(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int cur = 0, next = 0, len = chars.length;
        int max = 0;
        while(cur < len) {
            next = cur + 1;
            while (next < len && chars[cur] == chars[next]) {
                next++;
            }
            if (next - cur > max) {
                max = next - cur;
            }
            cur = next;
        }

        return max;
    }
}
