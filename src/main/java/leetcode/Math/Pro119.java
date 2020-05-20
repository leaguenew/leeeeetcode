package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-23 00:15
 **/
public class Pro119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == 1) {
                list.add(1);
                continue;
            }
            list.add(1);
            for(int j = list.size() - 2; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Pro119 pro = new Pro119();
        List<Integer> list = pro.getRow(3);
        System.out.println(list);
    }
}
