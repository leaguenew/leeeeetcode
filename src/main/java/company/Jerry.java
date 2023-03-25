package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * requirement:
 * Write a program that outputs all possibilities to put + or - or nothing between the numbers 1, 2, ..., 9 (in this order)
 * such that the result is always 100. For example: 1 + 2 + 34 – 5 + 67 – 8 + 9 = 100.
 *
 * input:
 * 1)List<Integer> list [1,2,3,4,5,6,7,8,9]
 * 2)int target
 *
 * output:
 * 1)List<String> expression
 *
 * alg design:
 * 1)search
 * 2)sum
 *
 * code:
 *
 * unit test:
 *
 * complex:
 */
public class Jerry {


    private List<String> resList = new ArrayList<>();
    private int len;
    private int target;

    public List<String> findAllList(List<Integer> list, int target) {

        Class<Jerry> jerryClass = Jerry.class;

        if (null == list || list.size() == 0) {
            return resList;
        }

        len = list.size();
        this.target = target;
        dfs(list, new StringBuffer(), 0);

        List<String> res = new ArrayList<>();
        for(String str: resList) {
            if (str.charAt(0) != '+') {
                res.add(str);
            }

        }
        System.out.println(res.size());

        return res;
    }

    public void dfs(List<Integer> list, StringBuffer curStr,int idx) {

        if (idx == len) {
            if (target == sum(curStr.toString())) {
                resList.add(curStr.toString());
            }

            return;
        }

        StringBuffer sb1 = new StringBuffer(curStr);//case: space
        sb1.append(list.get(idx));
        dfs(list, sb1, idx + 1);

        StringBuffer sb2 = new StringBuffer(curStr);//case: "+"
        sb2.append("+");
        sb2.append(list.get(idx));
        dfs(list, sb2, idx + 1);

        StringBuffer sb3 = new StringBuffer(curStr);//case: "-"
        sb3.append("-");
        sb3.append(list.get(idx));
        dfs(list, sb3, idx + 1);
    }

    private int sum(String str) {

        Stack<String> stack = new Stack<>();
        //process string
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            str = "+" + str;
        }
        for(int i = 0; i < str.length(); ) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                stack.add(String.valueOf(str.charAt(i)));
                i++;
            } else {
                int j = i + 1;
                StringBuffer sb = new StringBuffer();
                sb.append(str.charAt(i));
                while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                    sb.append(str.charAt(j));
                    j++;
                }
                stack.add(sb.toString());
                i = j;
            }
        }

        Stack<Integer> stackInt = new Stack<>();
        //cal sum
        while (!stack.isEmpty()) {
            String val = stack.pop();
            String opt = stack.pop();
            if ("+".equals(opt)) {
                stackInt.add(Integer.parseInt(val));
            } else if ("-".equals(opt)) {
                stackInt.add(-Integer.parseInt(val));
            } else {
                System.out.println("error, opt = " + opt + ", val = " + val) ;
            }
        }
        int val  = 0;
        while (!stackInt.isEmpty()) {
            val += stackInt.pop();
        }

        return val;
    }

    public static void main(String[] args) {
        Jerry jerry = new Jerry();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println(jerry.findAllList(list, 100));
    }
}
