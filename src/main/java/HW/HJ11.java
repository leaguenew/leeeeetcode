package HW;

import java.util.Scanner;

public class HJ11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int val = in.nextInt();
        String str = String.valueOf(val);
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }

        System.out.println(sb.reverse().toString());
    }
}
