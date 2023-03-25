package leetcode.Backtrace;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: risk-leecode-example
 * @description: 回溯的方法，就是从1~n-1个位置选择4个递增的位置，然后组成字符串，判断是否合法即可，就是一个组合问题。
 * @author: niuliguo
 * @create: 2020-02-16 20:15
 **/
public class Pro93BD {

    private List<String> resList = new ArrayList<>();
    private List<List<Integer>> positionCombination = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (null == s || s.length() < 4 || s.length() > 12) {
            return resList;
        }

        /**
         * 从1~n-1中选4个递增组合数，做必要的剪枝操作
         */
        int n = s.length();
        backtracing(new ArrayList<>(), 1, n, 3);

//        System.out.println(positionCombination);

        for(List<Integer> list: positionCombination) {
//            if (s.length() - list.get(2) > 3 ||
//                    list.get(2) - list.get(1) > 3 ||
//                    list.get(1) - list.get(0) > 3 ||
//                    list.get(0) > 3 ||
//                    list.get(2) == s.length()) {
//                continue;
//            }
//            System.out.println("list = " + list + ", s = " + s);
            String s1 = s.substring(0, list.get(0));
            String s2 = s.substring(list.get(0), list.get(1));
            String s3 = s.substring(list.get(1), list.get(2));
            String s4 = s.substring(list.get(2), s.length());
//            System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", s3 = " + s3 + ", s4 = " + s4);
            if ( !s1.isEmpty() && Integer.valueOf(s1) >= 0 && Integer.valueOf(s1) <=255 && (s1.length() > 1? !s1.startsWith("0") : true) &&
                 !s2.isEmpty() && Integer.valueOf(s2) >= 0 && Integer.valueOf(s2) <=255 && (s2.length() > 1? !s2.startsWith("0") : true) &&
                 !s3.isEmpty() && Integer.valueOf(s3) >= 0 && Integer.valueOf(s3) <=255 && (s3.length() > 1? !s3.startsWith("0") : true)&&
                 !s4.isEmpty() && Integer.valueOf(s4) >= 0 && Integer.valueOf(s4) <=255 && (s4.length() > 1? !s4.startsWith("0") : true)) {
                resList.add(s1 + "." + s2 + "." + s3 + "." + s4);
            }
        }

        return resList;
    }

    private void backtracing(List<Integer> tmpList, int start, int n, int k) {

        if (k == 0) {
            positionCombination.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i = start; i <= n; i++) {
            /**
             * 剪枝
             */
            if (tmpList.size() > 0) {
                if (i - tmpList.get(tmpList.size() - 1) > 3) {
                    return;
                }
            } else if (i > 3) {
                return;
            }

            tmpList.add(i);
            backtracing(tmpList, i + 1, n, k - 1);
            tmpList.remove(tmpList.size() - 1); //backtrace
        }
    }

    public static void main(String[] args) {
        Pro93BD pro = new Pro93BD();
//        System.out.println(pro.restoreIpAddresses("25525511135"));
//        System.out.println(pro.restoreIpAddresses("0000"));
//        System.out.println(pro.restoreIpAddresses("1111"));
        System.out.println(pro.restoreIpAddresses("2552552552"));
    }
}
