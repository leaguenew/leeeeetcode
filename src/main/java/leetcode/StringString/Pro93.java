package leetcode.StringString;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-09-14 19:31
 **/
public class Pro93 {

    private List<String> resList = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {

        for(int i = 1; i <= 3; i++)
            for(int j = 1; j <= 3; j++)
                for(int k = 1; k <= 3; k++)
                    for(int l = 1; l <= 3; l++) {
                        if (i + j + k + l == s.length()) {
                            String str1 = s.substring(0, i);
                            String str2 = s.substring(i, i + j);
                            String str3 = s.substring(i + j, i + j + k);
                            String str4 = s.substring(i + j + k, i + j + k + l);

                            if ( (str1.length() > 1 &&str1.startsWith("0")) ||
                                    (str2.length() > 1 && str2.startsWith("0")) ||
                                    (str3.length() > 1 && str3.startsWith("0")) ||
                                    (str4.length() > 1 && str4.startsWith("0"))) {
                                continue;
                            }

                            int Int1 = Integer.parseInt(str1);
                            int Int2 = Integer.parseInt(str2);
                            int Int3 = Integer.parseInt(str3);
                            int Int4 = Integer.parseInt(str4);

                            if (Int1 <= 255 && Int2 <= 255 && Int3 <= 255 && Int4 <= 255) {
                                String temp = str1 + "." + str2 + "." + str3 + "." + str4;
                                if (temp.length() == s.length() + 3) {
                                    resList.add(temp);
                                }
                            }
                        }
                    }

        return resList;
    }

    private int size;
    private int arr[] = new int[4];

    public List<String> restoreIpAddresses1(String s) {

        if (s == null || s.length() == 0) {
            return resList;
        }

        size = s.length();

        dfs(s,0, 0);

        return resList;
    }

    private void dfs(String s, int pos, int index) {
        if (index == 4) {
            if (pos != size) {
                return;
            }
            //拼接字符串
            resList.add(String.valueOf(arr[0]) + "." + String.valueOf(arr[1]) + "." + String.valueOf(arr[2]) + "." +
                        String.valueOf(arr[3]));

            return;
        }

        for (int i = pos; i < pos + 3 && i < size; i++) {
            int l = pos, r = i;
            int val = Integer.parseInt(s.substring(l, r + 1));
            boolean flag = isValueValue(s.substring(l, r + 1));
            if(flag) {
                arr[index] = val;
                dfs(s, r + 1, index + 1);
            } else {
                continue;
            }
        }
    }

    private boolean isValueValue(String str) {
        //多位前导0
        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }
        //大于255
        if (Integer.parseInt(str) > 255) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Pro93 pro = new Pro93();

        String s = "25525511135";

        System.out.println(pro.restoreIpAddresses1(s));
    }
}
