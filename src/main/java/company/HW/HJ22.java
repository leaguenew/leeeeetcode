package company.HW;

import java.util.Scanner;

public class HJ22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int val = in.nextInt();
        while(val != 0) {
            int res = 0;
            if (val == 1) {
                System.out.println(0);
                continue;
            }
            if (val == 2) {
                System.out.println(1);
                continue;
            }
            while(val > 0) {
                val = val - 3 + 1;
                res++;
            }

            val = in.nextInt();
        }
    }
}
