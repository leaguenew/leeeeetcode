package HW;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HJ58 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            int val = in.nextInt();
            arr[i] = val;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0 ; i < k - 1; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.printf(String.valueOf(arr[k-1]));

    }
}
