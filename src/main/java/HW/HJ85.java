package HW;

import java.util.Map;
import java.util.Scanner;

/**
 * 最长回文子串, 参考Pro5
 */
public class HJ85 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();
        int res = 1;
        for(int i = 1; i <= str.length() - 1; i++) {
            int l, r;
            for ( l = i - 1, r = i; l>=0 && r <= str.length() - 1; l--, r++) {
                if (str.charAt(l) == str.charAt(r)) {
                    res = Math.max(res, r - l + 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
