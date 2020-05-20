package leetcode.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-23 12:56
 **/
public class Pro20 {

    private static HashMap<String, String> map = new HashMap<String, String>();

    static {
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
    }

    public boolean isValid(String s) {

        if (s == null || s.length() == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        for(int i = s.length() - 1; i >= 0; i--) {
            stack1.push(s.substring(i, i + 1));
        }
        while(!stack1.empty()) {
            String str1 = stack1.pop();
            if (!map.containsKey(str1)) {
                if (stack2.isEmpty()) {
                    return false;
                }
                String str2 = stack2.pop();
                if (map.get(str2).equals(str1)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                stack2.push(str1);
            }
        }

        return stack2.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        Pro20 pro = new Pro20();
        String str = "()[[[[[]]]]]{}";
        System.out.println(pro.isValid(str));
        str = "()[]{}}{";
        System.out.println(pro.isValid(str));
        str = "((";
        System.out.println(pro.isValid(str));
        str = "))";
        System.out.println(pro.isValid(str));
    }
}
