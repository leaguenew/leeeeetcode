package HW;

import java.util.Scanner;

public class HJ15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int res = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                res++;
            }
            n = n >> 1;
        }

        System.out.println(res);
    }
}
