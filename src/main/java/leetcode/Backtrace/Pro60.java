package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-02 23:52
 **/
public class Pro60 {

    private List<String> res = new ArrayList<String>();
    private int size;

    /**
     * 超时：生成全排列，然后返回
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {

        List<String> list = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        size = n;
        backtracing("", list, k);

        return res.get(k - 1);
    }

    private void backtracing(String cur, List<String> left, int num) {

        if(cur.length() == size && left.size() == 0) {
            res.add(cur);
            return;
        }

        for(int i = 0; i < left.size(); i++) {
            String temp = left.get(i);
            List<String> leftNew = new ArrayList<String>(left);
            leftNew.remove(i);
            if (num > 0) {
                backtracing(cur + temp, leftNew, num--);
            }
        }
    }

    public String getPermutation1(int n, int k) {

        this.k = k;
        backtracing1(new ArrayList<Integer>(), n);

        return resStr;
    }

    private String resStr = null;
    private int k ;
    private void backtracing1(List<Integer> list, int n) {

        System.out.println("list = " + list + ", n = " + n + ", k = " + k);
        if (k < 0) {
            return;
        }

        if(list.size() == n) {
            k--;
            if (k == 0) {
                StringBuffer sb = new StringBuffer();
                for(Integer Int: list) {
                    sb.append(String.valueOf(Int));
                }
                resStr = sb.toString();
            }
            return;
        } else if (list.size() > n) {
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            backtracing1(list, n);
            list.remove(list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) {
        Pro60 pro = new Pro60();
        System.out.println(pro.getPermutation(4, 9));
        System.out.println(pro.getPermutation1(4, 9));
    }
}
