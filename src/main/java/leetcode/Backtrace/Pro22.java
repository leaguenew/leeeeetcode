package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-04 15:50
 **/
public class Pro22 {

    private List<String> resList = new ArrayList<>();
    private int len ;
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return resList;
        }

        len = n;
        String str = "";
        backtracing(str, 0, 0, 2 * len);

        return resList;
    }

    private void backtracing(String str, int left, int right, int total) {
        if (left + right == total) {
            resList.add(str);
            return;
        }

        if (left < len) {
            backtracing(str + "(", left + 1, right, total);
        }
        if (right < left) {
            backtracing(str + ")", left, right + 1, total);
        }
    }

    public static void main(String[] args) {
        Pro22 pro = new Pro22();
        System.out.println(pro.generateParenthesis(3));
    }
}
