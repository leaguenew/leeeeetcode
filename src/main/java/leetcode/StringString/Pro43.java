package leetcode.StringString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * 逆置 + 存储 + 求和
 * @author: niuliguo
 * @create: 2020-02-14 15:24
 **/
public class Pro43 {

    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2) {
            return null;
        }
        if (num1.length() == 0 && num2.length() != 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < num2.length(); i++) {
                sb.append("0");
            }
            return sb.toString();
        }
        if (num1.length() != 0 && num2.length() == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < num1.length(); i++) {
                sb.append("0");
            }
            return sb.toString();
        }

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] chars1 = num1.toCharArray(); //['1','2','3']
        char[] chars2 = num2.toCharArray();//['4','5', '6']
        List<Integer> intList1 = reverse(chars1);//[3, 2, 1]
//        System.out.println("intList1 = " + intList1 );
        List<Integer> intList2 = reverse(chars2);//[6, 5, 4]
//        System.out.println("intList2 = " + intList2);
        List<List<Integer>> sumList = new ArrayList<>();
        for(int i = 0; i < intList2.size(); i++) {
            List<Integer> list = multiplySingle(intList1, intList2.get(i), i);
            System.out.println("list = " + list);
            sumList.add(list);
        }

        System.out.println("sumList = " + sumList);

        List<Integer> sumRes = new ArrayList<>();
        for(int i = 0; i < sumList.size(); i++) {
            sumRes = sum(sumRes, sumList.get(i));
        }

        Collections.reverse(sumRes);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sumRes.size(); i++) {
            sb.append(sumRes.get(i));
        }

        return sb.toString();
    }

    /**
     * 先乘机 + 再进位
     * @param list
     * @param n
     * @param zeros
     * @return
     */
    private List<Integer> multiplySingle(List<Integer> list, int n, int zeros) {
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < zeros; i++) {
            resList.add(0);
        }

        for(int i = 0; i < list.size(); i++) {
            resList.add(n * list.get(i));
        }
        for(int i = 0; i < list.size() - 1; i++) {
            resList.set(i + 1, resList.get(i + 1) + resList.get(i) / 10);
            resList.set(i, resList.get(i) % 10);
        }

        if (resList.get(resList.size() - 1) >= 10) {
            resList.add(resList.get(resList.size() - 1) / 10);
            resList.set(resList.size() - 2, resList.get(resList.size() - 2) % 10); //注意这里已经进位了，要减2
        }

        return resList;
    }

    /**
     * 先求和 + 再进位
     * @param left
     * @param right
     * @return
     */
    private List<Integer> sum(List<Integer> left, List<Integer> right) {
        if (left == null || left.size() == 0) {
            return right;
        }
        List<Integer> resList = new ArrayList<>();
        int len = Math.min(left.size(), right.size());
        for(int i = 0; i < len; i++) {
            resList.add( (left.get(i) + right.get(i)) );
        }
        if (len == left.size()) {
            for(int i = len; i < right.size(); i++) {
                resList.add(right.get(i));
            }
        } else {
            for(int i = len; i < left.size(); i++) {
                resList.add(left.get(i));
            }
        }
        /**
         * 进位
         */
        for(int i = 0; i < resList.size() - 1; i++) {
            if (resList.get(i) >= 10) {
                resList.set(i + 1, resList.get(i + 1) + resList.get(i) / 10);
                resList.set(i, resList.get(i) % 10);
            }
        }
        if (resList.get(resList.size() - 1) >= 10) {
            resList.add(resList.get(resList.size() - 1) / 10);
        } else {
            resList.set(resList.size() - 2, resList.get(resList.size() - 2) % 10);//注意这里已经进位了，要减2
        }

        return resList;
    }

    private List<Integer> reverse(char[] chars) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < chars.length; i++) {
            res.add(Integer.valueOf(String.valueOf(chars[chars.length - 1 - i])));
        }

        return res;
    }

    /**
     * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     * @param num1
     * @param num2
     * @return
     */
    public String multiply1(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int left = i + j, right = i + j + 1;
                int tmp = mul + arr[right];
                arr[left] += tmp / 10;
                arr[right] = tmp % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer Int : arr) {
            //过滤前导0
            if (Int == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(Int);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Pro43 pro = new Pro43();
        System.out.println(pro.multiply("123456789","987654321"));
    }
}
