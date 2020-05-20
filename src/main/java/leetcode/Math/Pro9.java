package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

public class Pro9 {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        List<Integer> list = new ArrayList<Integer>();
        while (x / 10 != 0) {
            list.add(x % 10);
            x = x / 10;
        }

        list.add(x);

        int length = list.size();
        boolean flag = false;
        int i;
        for(i = 0; i < length / 2; i++) {
            if (list.get(i).intValue() == list.get(length - 1 - i).intValue()) {
                continue;
            } else {
                break;
            }
        }

        if (i == length / 2 ) {
            flag = true;
        }

        return flag;
    }


    public static void main(String[] args) {

        Pro9 pro = new Pro9();

        boolean flag = pro.isPalindrome(1234321);

        System.out.println(flag);
    }
}
