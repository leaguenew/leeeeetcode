package company.HW;

import java.util.Scanner;

public class HJ31 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        for(int i = 0; i < str.length(); i++) {
            if ( ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                    || ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                    || " ".equals(String.valueOf(str.charAt(i)))) {
            } else {
                str = str.replace(String.valueOf(str.charAt(i)), " ");
            }
        }

        String[] strs = str.split("\\s+");
        for(int i = strs.length - 1; i > 0; i--) {
            System.out.printf(strs[i] + " ");
        }
        System.out.printf(strs[0]);

    }
}
