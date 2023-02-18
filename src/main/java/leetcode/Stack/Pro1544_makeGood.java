package leetcode.Stack;

import java.util.Stack;

public class Pro1544_makeGood {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        for(int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            if ( ('a' <= stack.peek() &&  stack.peek() <= 'z'
                    && 'A' <= s.charAt(i) && s.charAt(i) <= 'Z' && stack.peek().toString().toLowerCase().equals(String.valueOf(s.charAt(i)).toLowerCase()))
                 || ('A' <= stack.peek() &&  stack.peek() <= 'Z'
                    && 'a' <= s.charAt(i) && s.charAt(i) <= 'z') && stack.peek().toString().toLowerCase().equals(String.valueOf(s.charAt(i)).toLowerCase())) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
