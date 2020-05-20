package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-30 12:02
 **/
public class Pro401 {


    private int size;
    private List<String> res = new ArrayList<String>();
    public List<String> readBinaryWatch(int num) {

        if (num == 0) {
            res.add("0:00");
            return res;
        }
        size = num;
        backtracing(0, num, 10);

        return res;
    }

    private void backtracing(int curVal, int num, int pos) {

//        System.out.println("curVal = " + curVal + ", bitOntCnt = " + bitOneCnt(curVal) + ", num = " + num + ", pos = " + pos);
        if (bitOneCnt(curVal) == size) {
            processResult(curVal);
            return;
        }

        if (pos < 0 || num <= 0) {
            return;
        }

        backtracing(curVal | (1 << pos), num - 1, pos - 1); //pos位填1
        backtracing(curVal, num, pos - 1); //pos位填0
    }

    public void processResult(int n) {
        int hour = ((n & (1 << 9)) == 0 ? 0 : 8) +
                ((n & (1 << 8)) == 0 ? 0 : 4) +
                ((n & (1 << 7)) == 0 ? 0 : 2) +
                ((n & (1 << 6)) == 0 ? 0 : 1);
        int min = ((n & (1 << 5)) == 0 ? 0 : 32) +
                ((n & (1 << 4)) == 0 ? 0 : 16) +
                ((n & (1 << 3)) == 0 ? 0 : 8) +
                ((n & (1 << 2)) == 0 ? 0 : 4) +
                ((n & (1 << 1)) == 0 ? 0 : 2) +
                ((n & (1 << 0)) == 0 ? 0 : 1);
        //剪枝
        if (hour <= 11 && min <= 59) {
            String str = String.valueOf(hour) + ":" + (min < 10 ? "0" + String.valueOf(min) : String.valueOf(min));
            if (!str.equals("0:00")) {
                res.add(str);
            }
        }
    }

    public int bitOneCnt(int n) {
        int c = 0 ; // 计数器
        while (n > 0)
        {
            if((n & 1) == 1) // 当前位是1
                ++c ; // 计数器加1
            n >>= 1 ; // 移位
        }
        return c ;
    }


    /**
     * 这道题转换成从0~9这个是十个数中选n个的组合数，即C10n
     * @param
     */
    private List<String> resList = new ArrayList<String>();
    private List<List<Integer>> combination = new ArrayList<>();
    public List<String> readBinaryWatch1(int num) {

        backtracing1(new ArrayList<>(), 0, 9, num, 0);

        processCombinantion();

        return resList;
    }

    private void processCombinantion() {
        int[] map = new int[]{1, 2, 4, 8, 16, 32, 1, 2, 4, 8};
        for(List<Integer> list: combination) {
            int hour = 0;
            int min = 0;
            System.out.println(list);
            for(int i = 0; i < list.size(); i++) {
                if (list.get(i) < 6) {
                    min += map[list.get(i)];
                } else {
                    hour += map[list.get(i)];
                }
            }
            // System.out.println(min);
            // System.out.println(hour);
            if (min > 59 || hour > 12) {
                continue;
            }

            StringBuffer sb = new StringBuffer();
            sb.append(hour).append(":");

            if (min == 0) {
                sb.append("00");
            } else if (min < 10){
                sb.append("0").append(min);
            } else {
                sb.append(min);
            }

            resList.add(sb.toString());
        }
    }

    /**
     * @param tmpList: 临时结果数组
     * @param start: 数据起点
     * @param scope: 数据范围，比如计算10以内的，或者一段数组的组合排列等
     * @param cntLeft: 需要计算几次，或者说树的深度，或者说结果中变量的个数
     * @param sumLeft: 求和的剩余值
     */
    private void backtracing1(List<Integer> tmpList, int start, int scope, int cntLeft, int sumLeft) {
        if (cntLeft == 0) {
            combination.add(new ArrayList<>(tmpList));
        }
        if (cntLeft < 0) {
            return;
        }

        for(int i = start; i <= scope; i++) {
            tmpList.add(i);
            backtracing1(tmpList, i + 1, scope, cntLeft - 1, sumLeft);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    public static void main(String[] args) {
        Pro401 pro = new Pro401();
        System.out.println(pro.readBinaryWatch1(8));
    }
}
