package leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Pro674 {

    /**
     * fail
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        List<Integer> list = new ArrayList<Integer>();
        //去重
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == list.get(list.size() - 1)) {
                continue;
            }

            list.add(nums[i]);
        }

        //一次遍历即可，记录最长值
        int start = 0, end = 0, diff;
        while(end < list.size() - 1) {
            if (list.get(end) < list.get(end + 1)) {
                end++;
                diff = end - start + 1;
                if (diff > maxLength) {
                    maxLength = diff;
                }
                continue;
            }

            diff = end - start + 1;
            if (diff > maxLength) {
                maxLength = diff;
            }

            start = end + 1;
            end = start;
        }

        diff = end - start + 1;
        if (diff > maxLength) {
            maxLength = diff;
        }

        return maxLength;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int findLengthOfLCIS1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int l , r;
        int i = 1;
        int max = 1;
        while(i < nums.length) {
            l = i - 1;
            r = i;
            while(r < nums.length && nums[r] > nums[r - 1]) {
                max = Math.max(max, r - l + 1);
                r++;
            }
            i = r + 1;
        }

        return max;
    }

    /**
     * 动态规划：
     * dp[i]: 截止到i的最长连续升序序列
     * 状态转移方程：if(num[i] > num[i - 1]) dp[i] =  dp[i - 1] + 1;
     *             if(num[i] <= num[i - 1]) dp[i] = 1;
     * 结果：遍历找到最大的dp
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Pro674 pro = new Pro674();

        int[] a = new int[]{1,3,5,6,7};

        int len = pro.findLengthOfLCIS(a);

        System.out.println(len);
    }
}
