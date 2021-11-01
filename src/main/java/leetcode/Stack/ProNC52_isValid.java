package leetcode.Stack;


import java.util.Stack;

/**
 * 算法：
 * 遍历字符串，如果是左括号则入栈，如果是右括号，弹栈并比对是否匹配
 */
public class ProNC52_isValid {

    private boolean flag = true;
    public boolean isValid (String s) {
        // write code here
        if (null == s || s.length() == 0) {
            return true;
        }

        Stack<String> stack = new Stack<>();
        int i;
        for(i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            process(stack, ch);
            if (!flag) {
                break;
            }
        }

        return stack.isEmpty() && i == s.length();
    }

    private void process(Stack<String> stack, String ch) {
        if ("[".equals(ch) || "(".equals(ch) || "{".equals(ch)) {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) {
                flag = false;
                return;
            }
            String left = stack.pop();
            switch (left) {
                case "[":
                    if (!ch.equals("]") ) {
                       flag = false;
                    }
                    break;
                case "(":
                    if (!ch.equals(")") ) {
                        flag = false;
                    }
                    break;
                case "{":
                    if (!ch.equals("}") ) {
                        flag = false;
                    }
                    break;
            }
        }
    }
}
