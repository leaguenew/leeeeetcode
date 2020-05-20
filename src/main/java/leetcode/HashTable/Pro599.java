package leetcode.HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-23 11:03
 **/
public class Pro599 {

    private int idxSum = Integer.MAX_VALUE;
    private List<String> resList = new ArrayList<>();
    public String[] findRestaurant(String[] list1, String[] list2) {
        if ( (list1 == null || list1.length == 0) &&
                (list2 == null || list2.length == 0)) {
            return null;
        }

        for(int i = 0; i < list1.length; i++) {
            for(int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < idxSum) {
                        idxSum = i +j;
                        resList.clear();
                        resList.add(list1[i]);
                    } else if (i + j == idxSum)
                        resList.add(list1[i]);
                    }
            }

        }

        return resList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] str1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str2 = new String[]{"KFC", "Shogun", "Burger King"};
        Pro599 pro = new Pro599();
        System.out.println(pro.findRestaurant(str1, str2)[0]);
    }
}
