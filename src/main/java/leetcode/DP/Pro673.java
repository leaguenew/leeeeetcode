package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-02 20:11
 **/
public class Pro673 {

    public int findNumberOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int i, j, max;
        for(i = 1; i < len; i++) {
            max = 0;
            for(j = 0; j < i; j++) {
                if (nums[j] < nums[i]  && dp[j] > max) {
                    max = dp[j];
                }
            }
            if (max == 0) {
                dp[i] = 1;
            } else  {
                dp[i] = max + 1;
            }
        }

        max = dp[0];
        for(i = 1; i < len; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        int cnt = 0;
        for(i = 0; i < len; i++) {
            if (max == dp[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Pro673 pro = new Pro673();
        System.out.println();
    }
}
