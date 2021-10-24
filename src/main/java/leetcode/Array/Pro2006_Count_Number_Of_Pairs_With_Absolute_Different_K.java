package leetcode.Array;

public class Pro2006_Count_Number_Of_Pairs_With_Absolute_Different_K {


    public int countKDifference(int[] nums, int k) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
