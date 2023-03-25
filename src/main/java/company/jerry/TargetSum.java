package company.jerry;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目是给一串数字（0 - 9）每个数字之间可以加 + - 号或者不加，组成的表达式计算结果等于 给定的目标数，输出所有满足条件的表达式。
 * 例如： [1 2 3 4 5 6 7 8 9]  目标 100
 * 可能的组合：
 * 1 + 23 - 4 + 56 + 7 + 8 + 9
 * -1 - 2 + 34 - 5 - 6 + 78 + 9
 * ————————————————
 * 版权声明：本文为CSDN博主「xnninger」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/xnninger/article/details/115682070
 */
public class TargetSum {

    private List<String> res = new ArrayList<>();
    private int target;

    public List<String> targetSum(List<Integer> integerList, int target) {

        this.target = target;
        function(integerList, new StringBuffer(), 0);

        for(String item: res) {
            System.out.println(item);
        }

        return res;
    }

    private void function(List<Integer> leftList, StringBuffer curStr, int idx) {
        if ( idx == leftList.size() ) {
            System.out.println(curStr);
            if ( target == sumString(curStr)) {
                res.add(curStr.toString());
            }

            return;
        }

        int val = leftList.get(idx);
        StringBuffer list1 = new StringBuffer(curStr);
        list1.append(val);
        function(leftList, list1, idx + 1);

        StringBuffer list2 = new StringBuffer(curStr);
        list2.append("+");
        list2.append(val);
        function(leftList, list2, idx + 1);

        StringBuffer list3 = new StringBuffer(curStr);
        list3.append("-");
        list3.append(val);
        function(leftList, list3, idx + 1);
    }

    public int sumString(StringBuffer stringBuffer) {

        Stack<String> stack = new Stack<>();
        int i = 0, j = 0;
        while(i < stringBuffer.length()) {
           if (stringBuffer.charAt(i) == '+' || stringBuffer.charAt(i) == '-') {
                stack.push(String.valueOf(stringBuffer.charAt(i)));
                i++;
            } else {
                j = i + 1;
                StringBuffer sb = new StringBuffer();
                sb.append(stringBuffer.charAt(i));
                while (j < stringBuffer.length() &&
                        ((stringBuffer.charAt(j) <= '9' && stringBuffer.charAt(j) >= '0')) ) {
                    sb.append(stringBuffer.charAt(j));
                    j++;
                }
                stack.push(sb.toString());
                i = j;
            }
        }

        while (stack.size() >= 3) {
            String rightStr = stack.pop();
            String opt = stack.pop();
            String leftStr = stack.pop();
            int resTemp = 0;
            if (opt.equals("+")) {
                resTemp = Integer.parseInt(leftStr) + Integer.parseInt(rightStr);
            } else if (opt.equals("-")) {
                resTemp = Integer.parseInt(leftStr) - Integer.parseInt(rightStr);
            } else {
                System.out.println("error:" + leftStr + "," + opt + "," + rightStr);
            }

            stack.push(String.valueOf(resTemp));
        }
        if (stack.size() == 2) {
            String peek = stack.pop();
            String opt = stack.pop();
            if (opt.equals("-")) {
                return -Integer.parseInt(peek);
            } else {
                return Integer.parseInt(peek);
            }
        } else if (stack.size() == 1) {
            return Integer.parseInt(stack.pop());
        }


        return 0;
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        System.out.println(targetSum.targetSum(list, 100));
        System.out.println(targetSum.sumString(new StringBuffer("1+23-4+56+7+8+9")));

//        System.out.println(Integer.parseInt("03"));
    }



}
//1+23-4+56+7+8+9