package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-09-14 13:06
 **/
public class Pro91DP {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.startsWith("0") || s.contains("00")) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        int[] dp = new int[chars.length];

        char2Int(chars, nums);

        boolean flag = func(nums, dp);

        if (!flag) {
            return 0;
        }

        return  dp[dp.length - 1];
    }

    private boolean func(int[] nums, int[] dp) {

        if (nums.length >= 1) {
            if (nums[0] == 0) {
                return false;
            }
            dp[0] = 1;
        }
        if (nums.length >= 2) {
            if (nums[0] * 10 + nums[1] > 26) {
                if (nums[1] != 0) {
                    dp[1] = 1;
                } else {
                    dp[1] = 0;
                }
            } else if (nums[0] * 10 + nums[1] <= 26 && nums[0] * 10 + nums[1] >= 11
                    && nums[0] * 10 + nums[1] != 20) {
                dp[1] = 2;
            } else if (nums[0] * 10 + nums[1] == 10 || nums[0] * 10 + nums[1] == 20) {
                dp[1] = 1;
            } else {
                dp[1] = 0;
                return false;
            }
        }
        for(int idx = 2; idx < nums.length; idx++) {
            if (nums[idx - 1] * 10 + nums[idx] > 26) {
                if (nums[idx] == 0) {
                    return false;
                }
                dp[idx] = dp[idx - 1];
            } else if (nums[idx - 1] * 10 + nums[idx] >= 11 && nums[idx - 1] * 10 + nums[idx] <= 26 &&
                    nums[idx - 1] * 10 + nums[idx] != 20) {
                dp[idx] = dp[idx - 1] + dp[idx - 2];
            } else if (nums[idx - 1] * 10 + nums[idx] == 10 || nums[idx - 1] * 10 + nums[idx] == 20) {
                dp[idx] = dp[idx - 2];
            } else {
                dp[idx] = dp[idx - 1]; //对于"01~09"这些情况
            }

            if (dp[idx] == 0) {
                return false;
            }
        }

        return true;
    }

    private void char2Int(char[] chars, int[] nums) {
        for(int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }
    }

    public static void main(String[] args) throws Exception{
        Pro91DP pro = new Pro91DP();

        System.out.println(pro.numDecodings("20"));
    }
}
