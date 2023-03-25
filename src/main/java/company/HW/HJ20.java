package company.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ20 {

    public static final String OK = "OK";
    public static final String NG = "NG";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String input = in.next();
            if (input.length() <= 8) {
                System.out.println(NG);
                continue;
            }

            int[] typeCnt = new int[4];//0: A-Z; 1:a-z; 2:0-9; 3: other
            for (int i = 0; i < input.length(); i++) {
                char ch = input.substring(i, i + 1).charAt(0);
                if (0 <= (ch - 'A') && (ch - 'Z') <= 0) {
                    typeCnt[0]++;
                    continue;
                }
                if (0 <= (ch - 'a') && (ch - 'z') <= 0) {
                    typeCnt[1]++;
                    continue;
                }
                if (0 <= (ch - '0') && (ch - '9') <= 0) {
                    typeCnt[2]++;
                    continue;
                }
                typeCnt[3]++;
            }

            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (typeCnt[i] > 0) {
                    count++;
                }
            }
            if (count < 3) {
                System.out.println(NG);
                continue;
            }

            Boolean isPrinted = false;
            Map<String, Integer> str2cnt = new HashMap<>();
            for (int i = 0; i < input.length() - 2; i++) {
                if (str2cnt.containsKey(input.substring(i, i + 3))) {
                    System.out.println(NG);
                    isPrinted = true;
                    break;
                }
                str2cnt.put(input.substring(i, i + 3), 1);
            }

            if (!isPrinted) {
                System.out.println(OK);
            }
        }
    }
}
