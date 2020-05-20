package leetcode.StringString;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-22 18:54
 **/
public class Pro929 {

    private Set<String> resSet = new HashSet<>();
    public int numUniqueEmails(String[] emails) {
        if (null == emails || emails.length == 0) {
            return 0;
        }

        for(String email: emails) {
            String prefix = email.substring(0, email.indexOf("@"));
            String suffix = email.substring(email.indexOf("@"), email.length());
            String[] strArr = prefix.split("\\+");
            String[] strArr1 = strArr[0].split("\\.");
            String res = "";
            for(int i = 0; i < strArr1.length; i++) {
                res += strArr1[i];
            }
            resSet.add(res + "@" + suffix);
        }

        return resSet.size();
    }

    public static void main(String[] args) {

    }
}
