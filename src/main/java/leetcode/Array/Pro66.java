package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-24 01:19
 **/
public class Pro66 {

    public int[] plusOne(int[] digits) {
        reverseArray(digits);
        digits[0] += 1;
        for(int i = 0; i < digits.length - 1; i++) {
            if (digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                digits[i + 1] += 1;
            }
        }
        if(digits[digits.length - 1] < 10) {
            reverseArray(digits);
            return digits;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] % 10;
            int[] res = new int[digits.length + 1];
            res[digits.length] = 1;
            for(int i = 0; i < digits.length; i++) {
                res[i] = digits[i];
            }
            reverseArray(res);
            return res;
        }
    }

    private void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Pro66 pro =  new Pro66();
//        int[] digits = new int[]{1,2,3};
        int[] digits = new int[]{9, 9};

        int[] res = pro.plusOne(digits);

        for(Integer i : res) {
            System.out.println(i);
        }
    }
}
