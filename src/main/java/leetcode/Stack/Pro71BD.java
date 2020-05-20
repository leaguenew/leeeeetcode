package leetcode.Stack;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description: 用栈，从左到右思考问题而不是从右到左
 * @author: niuliguo
 * @create: 2020-02-14 21:56
 **/
public class Pro71BD {

    public String simplifyPath(String path) {
        if (null == path) {
            return null;
        }
        if (path.isEmpty()) {
            return "/";
        }
        String[] strArr = path.split("/");
        for(String str: strArr) {
            System.out.println(str);
        }
        Stack<String> stack = new Stack<>();
        for(String str: strArr) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (str.equals(".") || str.isEmpty()) {
                continue;
            } else {
                stack.push(str);
            }
        }

        String res = "";
        for(String str: stack) {
            System.out.println(str);
            res = res + "/" + str;
        }

        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        Pro71BD pro = new Pro71BD();
//        System.out.println(pro.simplifyPath("/a/b/d/.././d//"));
//        System.out.println(pro.simplifyPath("/../"));
        System.out.println(pro.simplifyPath("/home//foo/"));
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for(Integer Int: stack) {
            System.out.println(Int);
        }
    }
}
