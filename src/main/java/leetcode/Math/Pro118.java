package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-22 23:50
 **/
public class Pro118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    list.add(1);
                    continue;
                }
                if (j == i) {
                    list.add(1);
                    continue;
                }
                if (j < i && i > 0 && j > 0) {
                    list.add(resList.get(i - 1).get(j) + resList.get(i - 1).get(j - 1));
                }
            }

            resList.add(list);
        }

        return resList;
    }

    public static void main(String[] args) {
        Pro118 pro = new Pro118();
        List<List<Integer>> list = pro.generate(5);
        System.out.println(list);
    }
}
