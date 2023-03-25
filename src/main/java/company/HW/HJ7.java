package company.HW;

import java.util.Scanner;

public class HJ7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        double val = in.nextDouble();
        int valInt = (int)val;
        double diff = val - valInt;
        if (diff >= 0.5) {
            System.out.println(valInt + 1);
        } else {
            System.out.println(valInt);
        }
    }
}
