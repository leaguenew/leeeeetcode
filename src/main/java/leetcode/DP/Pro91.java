package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description: 递归的方式不写了，边界问题很蛋疼
 * @author: niuliguo
 * @create: 2019-09-14 11:33
 **/
public class Pro91 {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.startsWith("0") || s.contains("00")) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        int[] dps = new int[chars.length];

        char2Int(chars, nums);

        func(nums, nums.length - 1, dps);

        return existZero(dps);
    }

    private int existZero(int[] dps) {

        for(int i = 0; i < dps.length; i++) {
            if(dps[i] == 0) {
                return 0;
            }
        }

        return dps[dps.length - 1];
    }

    private int func(int[] nums, int idx, int[] dps) {

        if (idx == 0) {
            if (nums[idx] == 0) {
                dps[idx] = 0;
                return 0;
            } else {
                dps[idx] = 1;
                return 1;
            }
        }
        if (idx == 1) {
            if (nums[0] * 10 + nums[1] <= 26 && nums[0] * 10 + nums[1] >= 11) {
                dps[idx] = 2;
                return 2;
            } else {
                dps[idx] = 1;
                return 1;
            }
        }

        if (nums[idx - 1] * 10 + nums[idx] > 26) {
            if (nums[idx] == 0) {
                return 0;
            } else {
                return func(nums, idx - 1,  dps);
            }
        } else if (nums[idx - 1] * 10 + nums[idx] >= 11 && nums[idx - 1] * 10 + nums[idx] <=26 ) {
            return func(nums, idx - 1, dps) + func(nums, idx - 2, dps);
        } else {
            return func(nums, idx - 2, dps);
        }
    }

    private void char2Int(char[] chars, int[] nums) {
        for(int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }
    }

    public static void main(String[] args) {
        Pro91 pro = new Pro91();

        String s = "301";

        System.out.println(pro.numDecodings(s));
    }
}
