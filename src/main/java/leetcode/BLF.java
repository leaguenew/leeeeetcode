package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-28 18:34
 **/
public class BLF {

    private int val ;
    public void fun(String filepath, int val) {
        /**
         * file: 1
         *       2
         *       3
         *
         * val: 3
         * sout: 1,2
         *       3
         */
        File file = new File(filepath);
        List<Integer> list = new ArrayList<>();
        this.val = val;

        backtracing(list, new ArrayList<Integer>());
    }

    private void backtracing(List<Integer> list, List<Integer> sumList) {

        if (sum(sumList) == val) {
            System.out.println(sumList);
            return;
        } else if (sum(sumList) > val) {
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            sumList.add(list.get(i));
            List<Integer> tmpList = new ArrayList<>(list);
            tmpList.remove(list.get(i));
            backtracing(tmpList, new ArrayList<>(sumList));
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for(Integer Int: list) {
            sum += Int;
        }

        return sum;
    }

}
