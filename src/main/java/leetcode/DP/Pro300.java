package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * 解法一：dp
 * 1.dp[i]：表示以nums[i]为结尾的最长上升子序列的长度
 * 2.状态转移方程：dp[i] = 1 + max(dp[j] for j < i : num[j] < nums[i])
 * 3.初始化条件：dp[0] = 1
 * 4.输出结果：取最大的dp[i]
 * @author: niuliguo
 * @create: 2020-02-02 16:58
 **/
public class Pro300 {

    public int lengthOfLIS(int[] nums) {
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

        return max;
    }

    public static void main(String[] args) {
        Pro300 pro = new Pro300();
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(pro.lengthOfLIS(nums));
    }
}
