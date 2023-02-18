import java.util.regex.Pattern;

/**
 * 反转字符串
 * 输入一个字符串，字符串包括数字、英文和英文括号，将该字符串反转，英文左右括号内的内容当成一个整体处理。
 * 如 输入 abcd 返回dcba
 *    输入 abcd(efg  返回 gfe(dcba
 *    输入 abcd(efg) 返回 (efg)dcba
 *    输入  abcd((efg)  返回(efg)(dcba
 * 算法设计：
 * 1.string -> string[]
 * 2.
 */


public class Weipinhui {

    public String func(String str) {
        String[] strs = str.split("(^(^)..)");
        StringBuffer res = new StringBuffer();
        for(int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].startsWith("(")) {
                res.append(strs[i]);
            } else {
                StringBuffer sb = new StringBuffer(strs[i]);
                res.append(sb.reverse());
            }
        }

        return res.toString();
    }
}
