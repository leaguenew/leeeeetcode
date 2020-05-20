package leetcode.DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-21 11:46
 **/
public class Pro354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (null == envelopes || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1]; //[0]相同降序
                } else {
                    return o1[0] - o2[0]; //不同升序
                }
            }
        });

        int[] nums = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }

        return lengthOfLIS(nums);
    }

    /**
     * Pro300
     * @param nums
     * @return
     */
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

    }
}
