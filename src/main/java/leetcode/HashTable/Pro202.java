package leetcode.HashTable;

import java.util.HashSet;
import java.util.Set;

public class Pro202 {

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<Integer>();
        int digitSquare = n;
        while(true) {
            digitSquare = getDigitSquare(digitSquare);

            if (digitSquare == 1) {
                return true;
            } else {
                if (set.contains(digitSquare)) {
                    return false;
                } else {
                    set.add(digitSquare);
                }
            }
        }
    }

    private int getDigitSquare(int n) {

        int sum = 0;
        while(n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Pro202 pro = new Pro202();

        System.out.println(pro.isHappy(19));

    }
}
