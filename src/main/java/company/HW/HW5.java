package company.HW;

import java.util.Scanner;

public class HW5 {


    public  static char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        String str = inputStr.substring(2, inputStr.length());

        int sum = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            int pos = findPos(str.substring(i, i + 1).charAt(0));
            sum += pos * Math.pow(16, str.length() - 1 - i);
            System.out.println("sum=" + sum);

        }

        System.out.println(sum);
    }

    public static int findPos(char ch) {
        for(int i = 0; i < chars.length; i++) {
            if (ch == chars[i]) {
                System.out.println("i=" + i);
                return i;
            }
        }

        return 0;
    }
}
