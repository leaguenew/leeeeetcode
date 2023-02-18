package leetcode.Array;

public class Pro209 {

    public int minSubArrayLen(int target, int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int sum = 0, len = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            sum = 0;
            for(int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Pro209 pro = new Pro209();

        int[] nums = new int[]{2,3,1,2,4,3};

        int res = pro.minSubArrayLen(7, nums);

        System.out.println(res);
    }
}
