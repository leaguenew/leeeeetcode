package leetcode.Array;


import java.util.Arrays;

public class Pro628 {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        Pro628 pro = new Pro628();

//        int nums[] = new int[]{1,2,3,4};
        int nums[] = new int[]{-4,-3,-2,-1,60};

        System.out.println(pro.maximumProduct(nums));
    }
}
