package company.HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            process(in.nextLine());
        }
    }

    public static void process(String inputStr) {
        if (inputStr.contains(".")) {
            ipAddress2Int(inputStr);
        } else {
            int2IpAddress(inputStr);
        }
    }

    public static void ipAddress2Int(String inputStr) {
        String[] strs = inputStr.split("\\.");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 4; i++) {
            sb.append(int2binary(strs[i]));
        }

        System.out.println(binary2int(sb.toString()));
    }

    public static int binary2int(String binaryStr) {
        int sum = 0;
        for(int pos = binaryStr.length() - 1 ; pos >= 0; pos--) {
            if (binaryStr.charAt(pos) == '1') {
                sum += Math.pow(2, binaryStr.length() - 1 - pos);
            }
        }

        return sum;
    }

    public static String int2binary(String str) {
        int val = Integer.parseInt(str);
        StringBuffer binarySb = new StringBuffer();
        while(val / 2 != 0) {
            int temp = val % 2;
            binarySb.append(temp);
            val = val >> 1;
        }
        binarySb.append(1);
        for(int i = binarySb.length(); i < 8; i++) {
            binarySb.append("0");
        }
        binarySb.reverse();

        return binarySb.toString();
    }

    public static void int2IpAddress(String inputStr) {

    }

}
