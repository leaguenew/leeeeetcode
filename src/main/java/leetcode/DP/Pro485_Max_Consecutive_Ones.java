package leetcode.DP;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-07-30 09:58
 **/
public class Pro485_Max_Consecutive_Ones {

    /**
     * 算法一：双重循环
     * 时间：O(n^2)
     * 空间：O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = 0, i, j;
        for(i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }

            /**
             * 剪枝
             */
            if (max > len - i) {
                break;
            }

            for(j = i + 1; j < len && nums[j] == 1; j++);
            if (j - i > max)  {
                max = j - i;
            }
        }

        return max;
    }

    /**
     * 算法二：动态规划
     * 1.子问题：整体数组的最大连续1的长度跟有关
     * 2.状态定义：dp[i], 已nums[i]结尾的最长连续1的个数
     * 3.状态转移：dp[i] = nums[i] == 1 ? dp[i-1] + 1 : 0;
     * 4.初始化：xxx
     * 5.结果：找到最大的dp[i]
     * 时间：O(n)
     * 空间：O(n)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0] == 1 ? 1 : 0;
        int max = dp[0];
        for(int i = 1; i < len; i++) {
            dp[i] = nums[i] == 1 ? dp[i-1] + 1 : 0;
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    /**
     * 算法三：动规简化,最快解法
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int oneCnt = nums[0] == 1 ? 1 : 0;
        int max = oneCnt;
        for(int i = 1; i < len; i++) {
            oneCnt = nums[i] == 1 ? oneCnt + 1 : 0;
            if (oneCnt > max) {
                max = oneCnt;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Pro485_Max_Consecutive_Ones pro = new Pro485_Max_Consecutive_Ones();
        int[] nums = new int[]{0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1};
        System.out.println(pro.findMaxConsecutiveOnes2(nums));
    }
}
