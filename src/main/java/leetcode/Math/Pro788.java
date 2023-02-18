package leetcode.Math;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-09 18:49
 **/
public class Pro788 {

    private List<Integer> goodList = new ArrayList<>();
    private List<Integer> notGoodList = new ArrayList<>();
    private List<Integer> commondList = new ArrayList<>();
    public int rotatedDigits(int N) {
        goodList.add(2);
        goodList.add(5);
        goodList.add(6);
        goodList.add(9);
        notGoodList.add(3);
        notGoodList.add(4);
        notGoodList.add(7);
        commondList.add(0);
        commondList.add(1);
        commondList.add(8);
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if (isGoodNum(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private boolean isGoodNum(int n) {
        int flag1 = 0; //flag1:一般的数；
        int flag2 = 0; //flag2:好数；
        int flag3 = 0; //flag3:不好的数
        while(n / 10 > 1) {
            int val = n % 10;
//            if (commondList.contains(val)) {
//                flag1++;
//                continue;
//            }
            if (goodList.contains(val)) {
                flag2++;
                continue;
            }
            if (notGoodList.contains(val)) {
                flag3++;
                break;
            }
            n = n / 10;
        }

        if (flag3 > 0) {
            return false;
        }

//        if (commondList.contains(n)) {
//            flag1++;
//        }
        if (goodList.contains(n)) {
            flag2++;
        }
        if (notGoodList.contains(n)) {
            flag3++;
        }

        if (flag3 > 0) {
            return false;
        }

        if (flag2 > 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Pro788 pro = new Pro788();
        System.out.println(pro.rotatedDigits(10));
    }
}
