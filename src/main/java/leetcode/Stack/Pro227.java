package leetcode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-17 20:43
 **/
public class Pro227 {

    Stack<String> stack = new Stack<>();
    public int calculate(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        List<String> list = processList(s);

        return calculateWithStack(list);
    }

    private List<String> processList(String s) {
        String[] arr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String str: arr) {
            sb.append(str);
        }
        String formatStr = sb.toString();
        int l = 0, r = 0;
        List<String> resList = new ArrayList<>();
        while(r < formatStr.length()) {
            if (formatStr.charAt(r) == '+' ||
                formatStr.charAt(r) == '-' ||
                formatStr.charAt(r) == '*' ||
                formatStr.charAt(r) == '/'
                    ) {
                resList.add(formatStr.substring(l, r));
                resList.add(formatStr.substring(r, r + 1));
                l = r + 1;
                r = l;
                continue;
            }
            r++;
        }
        resList.add(formatStr.substring(l, r));

        return resList;
    }

    private int calculateWithStack(List<String> list) {
        for(int i= 0; i < list.size(); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                String peekStr = stack.pop();
                int leftInt = Integer.parseInt(peekStr);
                int rightInt = Integer.parseInt(list.get(i + 1));
                stack.push(String.valueOf(list.get(i).equals("*") ? leftInt * rightInt : leftInt / rightInt));
                i++;
            } else {
                stack.push(list.get(i));
            }
        }

        /**
         * 加减法从左到右
         */
        Stack<String> stack1 = new Stack<>();
        while (stack.size() > 0) {
            String item = stack.pop();
            stack1.push(item);
        }
        while(stack1.size() > 1) {
            int leftInt = Integer.parseInt(stack1.pop());
            String op = stack1.pop();
            int rightInt = Integer.parseInt(stack1.pop());
            stack1.push(String.valueOf(op.equals("-") ? leftInt - rightInt : leftInt + rightInt));
        }

        return Integer.parseInt(stack1.peek());
    }

    public static void main(String[] args) {
        Pro227 pro = new Pro227();
        System.out.println(pro.calculate("33+2*2"));
        System.out.println(pro.calculate("33-2+2"));
    }
}
