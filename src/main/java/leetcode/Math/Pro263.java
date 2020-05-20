package leetcode.Math;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-09 11:47
 **/
public class Pro263 {

    public boolean isUgly(int num) {

        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        while(num > 0) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            if (num == 1) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Pro263 pro = new Pro263();
        System.out.println(pro.isUgly(12));
        System.out.println(pro.isUgly(536870911));
    }
}









