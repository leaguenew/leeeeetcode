package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-03 21:53
 **/
public class Pro507 {

    public boolean checkPerfectNumber(int num) {

        if (num == 0) {
            return false;
        }

        List<Integer> list = new ArrayList<Integer>();
        int i = 1;
        while (i <= num/2) {
            if (num % i == 0) {
                list.add(i);
            }
            i++;
        }
        int sum = 0;
        for(i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Pro507 pro = new Pro507();
        System.out.println(pro.checkPerfectNumber(28));
    }
}
