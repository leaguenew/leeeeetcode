package leetcode.Stack;

import com.sun.tools.javac.util.Assert;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-23 23:01
 **/
public class Pro1003 {

    /**
     * 写得太复杂了，而且过不了
     * @param S
     * @return
     */
    public boolean isValid(String S) {
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> stackTemp;
        for(int i = S.length() - 1; i >= 0; i--) {
            stack1.push(S.substring(i, i + 1));
        }

        int changed = 0;
        while(!stack1.empty() || !stack2.empty()) {

            System.out.println("start stack1 = " + stack1 + ", stack2 = " + stack2 + ", stack1.size = " + stack1.size()
                            + ", stack2.size = " + stack2.size());
            if (stack1.empty()) {
                if (stack2.empty()) {
                    break;
                }
                while(!stack2.empty()) {
                    String temp = stack2.pop();
                    stack1.push(temp);
                }
                if (changed == 2) {
                    break;
                }
                changed = 0;
            }

            if (stack1.size() + stack2.size() < 3) {
                break;
            }
            System.out.println("mid stack1 = " + stack1 + ", stack2 = " + stack2 + ", stack1.size = " + stack1.size()
                    + ", stack2.size = " + stack2.size());
            String temp;
            if (stack2.empty()) {
                temp = stack1.pop();
                stack2.push(temp);
            }

            String peek1 = stack1.peek();
            String peek2 = stack2.peek();
            if (peek2.equals("a") && peek1.equals("b")) {
                temp = stack1.pop();
                stack2.push(temp);
                if (stack1.size() > 0) {
                    peek1 = stack1.peek();
                    if (peek1.equals("c")) {
                        stack1.pop();
                        stack2.pop();
                        stack2.pop();
                    } else {
                        temp = stack1.pop();
                        stack2.push(temp);
                    }
                }
            } else {
                temp = stack1.pop();
                stack2.push(temp);
            }
            changed++;
            System.out.println("end stack1 = " + stack1 + ", stack2 = " + stack2 + ", stack1.size = " + stack1.size()
                    + ", stack2.size = " + stack2.size() +",changed = " + changed);
            System.out.println();
        }

        System.out.println("final stack1 = " + stack1 + ", stack2 = " + stack2 + ", stack1.size = " + stack1.size()
                + ", stack2.size = " + stack2.size());

        return stack1.empty() && stack2.empty() ? true : false;
    }

    public boolean isValid1(String S) {

        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < S.length(); i++) {
            String temp = S.substring(i, i + 1);
            if (temp.equals("c")) {
                if (stack.size() >= 2) {
                    String peek = stack.pop();
                    String peek1 = stack.pop();
                    if (peek1.equals("a") && peek.equals("b")) {
                        continue;
                    } else {
                        stack.push(peek1);
                        stack.push(peek);
                    }
                } else {
                    stack.push(temp);
                }
            } else {
                stack.push(temp);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Pro1003 pro = new Pro1003();

//        System.out.println(pro.isValid("abc"));
//        assert (pro.isValid("abc"));
//        assert true;
//
//        System.out.println(pro.isValid("aabcbc"));//true
//        assert (pro.isValid("aabcbc"));//true
//        assert true;//true
//
//        System.out.println(pro.isValid("abcaabcbc"));//true
//        assert (pro.isValid("abcaabcbc"));//true
//        assert true;//true
//
//        System.out.println(pro.isValid("abcaaaabcbc"));//false
//        assert (pro.isValid("abcaaaabcbc"));//false
//        assert false;
//
//        System.out.println(pro.isValid("aaabcbcbabcc"));//true
//        assert (pro.isValid("aaabcbcbabcc"));//true
//        assert true;//true
//
//        System.out.println(pro.isValid("abccba"));//false
//        assert (pro.isValid("abccba"));
//        assert false;
//
        System.out.println(pro.isValid1("abcabcababcc"));
        assert (pro.isValid1("abcabcababcc")) == true;

        System.out.println(pro.isValid1("cababc"));
        assert (pro.isValid1("cababc")) == false;
    }
}
