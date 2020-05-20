package leetcode.Stack;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-21 11:04
 **/
public class Pro844 {

    public boolean backspaceCompare(String S, String T) {

        if ( (S == null && T == null) ||
                (S.length() == 0 && T.length() == 0)) {
            return true;
        }

        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        process(stack1, S);
        process(stack2, T);
        if (stack1.size() != stack2.size()) {
            return false;
        } else {
            while(stack1.size() > 0) {
                if (!stack1.pop().equals(stack2.pop())) {
                    return false;
                }
            }

            return true;
        }
    }

    private void process(Stack<String> stack, String str) {
        for(int i = 0; i < str.length(); i++) {
            if ("#".equals(str.substring(i, i + 1))) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str.substring(i, i + 1));
            }
        }
    }

    public static void main(String[] args) {
        Pro844 pro = new Pro844();
        System.out.println(pro.backspaceCompare("ab##c", "ad##c"));
        System.out.println(pro.backspaceCompare("ab#c", "ad#c"));
        System.out.println(pro.backspaceCompare("ab##c", "ad#c"));
    }
}
