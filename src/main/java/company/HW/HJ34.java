package company.HW;

import java.util.Arrays;
import java.util.Scanner;

public class HJ34 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String inputStr = in.next();
        char[] chars = inputStr.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
    }
}
