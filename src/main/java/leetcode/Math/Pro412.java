package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-05-17 23:33
 **/
public class Pro412 {

    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();
        if (n <= 0) {
            return resList;
        }

        for(int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resList.add("Fizz");
            } else if (i % 5 == 0) {
                resList.add("Buzz");
            } else {
                resList.add(String.valueOf(i));
            }
        }

        return resList;
    }
}
