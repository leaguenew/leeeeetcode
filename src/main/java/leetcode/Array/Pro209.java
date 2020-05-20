package leetcode.Array;

public class Pro209 {

    public int minSubArrayLen(int s, int[] nums) {

        int window = 0 , len = nums.length, sum = 0;
        for (int i = 0, j = 0; i < len && j < len;) {
            if (i == j) {
                sum = nums[i];
                if (sum > s) {
                    return j - i + 1;
                }

                j++;
            }
//            /if ()

        }

        return 0;
    }

    public static void main(String[] args) {
        Pro209 pro = new Pro209();

        int[] nums = new int[]{2,3,1,2,4,3};

        int res = pro.minSubArrayLen(7, nums);

        System.out.println(res);
    }
}
