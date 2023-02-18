package HW;

import java.util.Scanner;

public class HJ13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        String[] strArrs = str.split("\\s+");
        for(int i = strArrs.length - 1; i > 0; i--) {
            System.out.printf(strArrs[i] + " ");
        }
        System.out.printf(strArrs[0]);

    }
}
