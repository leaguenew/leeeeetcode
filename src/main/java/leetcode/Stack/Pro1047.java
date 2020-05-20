package leetcode.Stack;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-23 11:00
 **/
public class Pro1047 {

    private Stack<Character> stack = new Stack<>();
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        for(Character character: S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(character);
                continue;
            }
            if (character == stack.peek()) {
                stack.pop();
            } else {
                stack.add(character);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Character c = stack.pop();
            sb.append(c);
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        Pro1047 pro = new Pro1047();
        System.out.println(pro.removeDuplicates("aabbc"));
        System.out.println(pro.removeDuplicates("abbaca"));
    }
}
