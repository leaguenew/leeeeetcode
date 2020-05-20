package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-05 22:20
 **/
public class Pro77 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private int size;
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> origin = new ArrayList<Integer>();
        for(int i = 1; i <=n; i++) {
            origin.add(i);
        }

        size = k;
        backtracing(new ArrayList<Integer>(), origin);

        return res;
    }

    private void backtracing(List<Integer> cur, List<Integer> left) {
        if (cur.size() == size) {
            res.add(cur);
            return;
        }

        for(int i = 0; i < left.size(); i++) {
            int val = left.get(i);
            List<Integer> curTmp = new ArrayList<Integer>(cur);
            curTmp.add(val);
            /**
             * 排列和组合唯一的区别就是leftTemp的处理：
             * 对于全排列来说：leftTemp等于left
             * 对于组合来说：leftTemp要比cur中所有的值都要大，也就是要大于val才能添加到leftTemp中
             */
            List<Integer> leftTemp = new ArrayList<Integer>();
            if (left.size() - i >= 2) {
                leftTemp.addAll(left.subList(i + 1, left.size()));
            }

            backtracing(curTmp, leftTemp);
        }
    }

    public static void main(String[] args) {
        Pro77 pro = new Pro77();
        System.out.println(pro.combine(4, 2));

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.addAll(list.subList(2, list.size() - 1));

        System.out.println(list1);
    }
}
