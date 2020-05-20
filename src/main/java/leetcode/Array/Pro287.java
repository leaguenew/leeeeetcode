package leetcode.Array;

import java.util.Arrays;

public class Pro287 {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return nums[i];
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        Pro287 pro = new Pro287();
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(pro.findDuplicate(nums));
    }
}
