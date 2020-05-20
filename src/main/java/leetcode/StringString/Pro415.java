package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-24 10:10
 * Company: ByteDance(similar to Pro43)
 **/
public class Pro415 {

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int maxLen = Math.max(len1, len2);
        int[] arr = new int[maxLen + 1];
        for(int i = 0; i < maxLen; i++) {
            int idx1 = len1 - i - 1;
            int idx2 = len2 - i - 1;
            int idx = maxLen - i;
            if (idx1 >= 0 && idx2 >= 0) {
                int sum = (chars1[idx1] - '0') + (chars2[idx2] - '0') + arr[idx] ;
                arr[idx] = sum % 10;
                arr[idx - 1] = arr[idx - 1] + sum / 10;
            } else if (idx1 >= 0 && idx2 < 0) {
                int sum = (chars1[idx1] - '0') + arr[idx];
                arr[idx] = sum % 10;
                arr[idx - 1] = arr[idx - 1] + sum / 10;
            } else {
                int sum = (chars2[idx2] - '0') + arr[idx];
                arr[idx] = sum % 10;
                arr[idx - 1] = arr[idx - 1] + sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer Int : arr) {
            //过滤前导0
            if (Int == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(Int);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Pro415 pro = new Pro415();
        System.out.println(pro.addStrings("584", "18"));
    }
}
