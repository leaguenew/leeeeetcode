package leetcode.Array;

/**
 * 类似：最长重复子串
 * 子问题：arr1与arr2的最长重复子数组
 * 状态定义：dp[i][j]: arr1[1..i] 与 arr2[1..j]最长重复子数组的长度
 * 状态转移：if arr1[i] == arr2[j]:
 *             dp[i][j] = dp[i - 1][j - 1] + 1;
 *         else:
 *             dp[i][j] = 0;
 */
public class Pro718_Maximum_Length_Of_Repeated_Subarray {

    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return maxLen;
        }

        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }

                max = Math.max(max, dp[i + 1][j + 1] );
            }
        }

        return max;
    }
}

