package company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


/**
 * @description: revere the string list
 * @className: Main
 * @author: Liguo Niu
 * @Date: 2023-02-23
 */
public class HW2 {

    public static String main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //process the init string
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            if ( isChar(str.charAt(i)) ) {
                sb.append(str.charAt(i));
            } else {
                if (str.charAt(i) == '-') {
                    if(i == 0 ) {
                        sb.append(' ');
                    } else if (i == str.length() - 1 ) {
                        sb.append(' ');
                    } else if (isChar(str.charAt(i - 1)) && isChar(str.charAt(i + 1))) {
                        sb.append(str.charAt(i));
                    } else {
                        sb.append(' ');
                    }
                } else {
                    sb.append(' ');
                }
            }
        }

        String tmp = sb.toString();
        String[] strs = tmp.split("\\s+");//split the string by space
        StringBuffer res = new StringBuffer();
        //join the string from end to start
        for(int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        //print the result
        System.out.println(res.toString());

        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        String s = String.format("{  \"currentTime\": %s, \"status\": \"OK\" }", df.format(new Date()));
        StringBuffer sb1 = new StringBuffer(s);
        sb1.deleteCharAt(sb1.length() - 1).append("+01:00[Europe/Warsaw]");

        return sb1.toString();
    }

    /**
     * @description: check if the input char is valid
     * @param ch
     * @return boolean
     */
    public static boolean isChar(char ch) {
        if (('a' <= ch && ch <= 'z') ||
                ('A' <= ch && ch <= 'Z') ||
                ('0' <= ch && ch <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
