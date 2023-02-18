package HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        String[] arr = new String[n];
        while (n-- > 0) {
            String str = in.nextLine();
            arr[n] = str;
        }
        Arrays.sort(arr);
        for(String str: arr) {
            if (str.equals("\\n")) {
                continue;
            }
            System.out.println(str);
        }
    }
}
