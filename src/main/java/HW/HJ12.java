package HW;

import java.util.Scanner;

public class HJ12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.reverse().toString());
    }
}
