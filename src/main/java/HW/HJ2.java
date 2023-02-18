package HW;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ch = in.nextLine();

        int cnt = 0;
        int len = str.length();
        System.out.println(str);
        System.out.println(ch);
        for(int i = 0; i < len; i++) {
            String temp = str.substring(i, i + 1);
            if (ch.toLowerCase().equals(temp.toLowerCase())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
