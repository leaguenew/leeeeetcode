package HW;

import java.util.Scanner;

public class HJ1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String curr = null;
        while (in.hasNext()) { // 注意 while 处理多个 case
             curr = in.next();
        }
        System.out.println(curr.length());
    }

}
