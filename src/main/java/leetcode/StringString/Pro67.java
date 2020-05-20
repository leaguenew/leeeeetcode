package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-23 14:37
 **/
public class Pro67 {

    public String addBinary(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        char[] res = new char[Math.max(chars1.length, chars2.length) + 1];
        res[res.length - 1] = '0';

        int h = 0, i, j;
        for(i = chars1.length - 1, j = chars2.length - 1; i >=0 && j>=0; i--, j--) {
            if (chars1[i] == '0' && chars2[j] == '0') {
                res[h++] = '0';
            } else if ( (chars1[i] == '1' && chars2[j] == '0') ||
                        (chars1[i] == '0' && chars2[j] == '1')) {
                res[h++] = '1';
            } else {
                res[h++] = '2';
            }
        }
        if (i>=0) {
            while(i >=0 ) {
                res[h++] = chars1[i];
                i--;
            }
        } else {
            while(j >=0 ) {
                res[h++] = chars2[j];
                j--;
            }
        }
        i = 0;
        while(i < res.length - 2) {
            if (res[i] == '2') {
                res[i] = '0';
                res[i + 1] = (char)('0' + Integer.parseInt(String.valueOf(res[i + 1])) + 1);
            } else if (res[i] == '3') {
                res[i] = '1';
                res[i + 1] = (char)('0' + Integer.parseInt(String.valueOf(res[i + 1])) + 1);
            }
            i++;
        }
        if (res[i] == '2') {
            res[i] = '0';
            res[i + 1] = '1';
        } else if (res[i] == '3') {
            res[i] = '1';
            res[i + 1] = '1';
        }
        reverseString(res);

        String str = String.valueOf(res);
        if (str.substring(0, 1).equals("0")) {
            return str.substring(1, str.length());
        } else {
            return str;
        }
    }

    private void reverseString(char[] chars) {
        int start = 0, end = chars.length - 1;
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        Pro67 pro = new Pro67();
//        System.out.println(pro.addBinary("1010", "1011"));
        System.out.println(pro.addBinary("110010", "10111"));
//        System.out.println(pro.addBinary("11", "1"));
    }
}
