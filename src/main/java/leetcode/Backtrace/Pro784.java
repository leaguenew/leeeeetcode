package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-02 23:45
 **/
public class Pro784 {

    private List<String> res = new ArrayList<String>();
    private List<String> digits = Arrays.asList(
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private int size;

    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return res;
        }
        size = S.length();
        backtracing("", S);

        return res;
    }

    private void backtracing(String cur, String left) {
        if (cur.length() == size && left.length() == 0) {
            res.add(cur);
            return;
        }

        for(int i = 0; i < left.length(); i++) {
            String temp = left.substring(i, i + 1);
            if (digits.contains(temp)) {
                cur += temp;
                if (cur.length() == size) {
                    res.add(cur);
                }
            } else {
                if (Character.isUpperCase(temp.charAt(0))) {
                    backtracing(cur + temp, left.substring(i + 1));
                    backtracing(cur + temp.toLowerCase(), left.substring(i + 1));
                } else {
                    backtracing(cur + temp, left.substring(i + 1));
                    backtracing(cur + temp.toUpperCase(), left.substring(i + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Pro784 pro = new Pro784();
//        System.out.println(pro.letterCasePermutation("1a2Bc2"));
//        System.out.println(pro.letterCasePermutation("z21"));
        System.out.println(pro.letterCasePermutation("12345"));
    }
}


