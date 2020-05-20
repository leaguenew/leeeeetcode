package leetcode.StringString;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-05 23:46
 **/
public class Pro38 {

    private List<String> resList = new ArrayList<>();
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        resList.add("1");
        if (n == 1) {
            resList.get(n - 1);
        }
        for(int i = 1; i < n; i++) {
            resList.add(process(resList.get(i - 1)));
        }

        return resList.get(n - 1);
    }

    private String process(String str) {
        char[] chars = str.toCharArray();
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while(l < chars.length) {
            while(r < chars.length && chars[l] == chars[r]) {
                r++;
            }

            int count = r - l;
            sb.append(String.valueOf(count)).append(chars[l]);
            l = r;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Pro38 pro = new Pro38();
        System.out.println(pro.countAndSay(7));
    }
}
