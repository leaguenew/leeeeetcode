package leetcode.DP;

public class Pro153 {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
        }

        //find max in dp array
        int max = dp[0];
        for(int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public int maxProduct1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int product = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                product = product * nums[j];
                if (product > max) {
                    max = product;
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Pro153 pro = new Pro153();

        int nums[] = new int[]{2,3,-2,4};
//        int nums[] = new int[]{-2,0,-1};

        System.out.println(pro.maxProduct1(nums));

    }
}
