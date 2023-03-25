package company.HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int len = str.length();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < len; i++) {
            String temp = str.substring(i, i+1);
            if (!temp.equals(" ")) {
                sb.append(temp);
            }
        }

        String processedStr = sb.toString();
        List<String> resList = new ArrayList<>();
        int j;
        for(j = 0; j < processedStr.length(); j = j + 8) {
            if (j + 8 > processedStr.length()) {
                break;
            } else {
                resList.add(processedStr.substring(j, j + 8));
            }
        }

        if (j < processedStr.length()) {
            int zeros = 8 - (processedStr.length() - j);
            StringBuffer zeroSB = new StringBuffer();
            zeroSB.append(processedStr.substring(j, processedStr.length()));
            for (int i = 0; i < zeros; i++) {
                zeroSB.append("0");
            }

            resList.add(zeroSB.toString());
        }

        for(int i = 0 ; i < resList.size(); i++) {
            System.out.println(resList.get(i));
        }
    }
}
