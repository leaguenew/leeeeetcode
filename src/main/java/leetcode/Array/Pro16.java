package leetcode.Array;

import java.util.Arrays;

/**
 * @program: risk-leecode-example
 * @description:
 * 算法：排序 + 二分找到最近的下标 + 左右求和
 * @author: niuliguo
 * @create: 2020-02-04 10:32
 **/
public class Pro16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestIndex = Arrays.binarySearch(nums, target);

        if (closestIndex >= 0) {
            if (closestIndex == 0) {
                return nums[closestIndex] + nums[closestIndex + 1] + nums[closestIndex + 2];
            } else if (closestIndex == nums.length - 1) {
                return nums[closestIndex] + nums[closestIndex - 1] + nums[closestIndex - 2];
            } else if (closestIndex == 1 || closestIndex == nums.length - 2) {
                int dist1 = nums[closestIndex - 1] + nums[closestIndex] + nums[closestIndex + 1] - target;
                int dist2 = nums[closestIndex] + nums[closestIndex + 1] + nums[closestIndex + 2] - target;
                if (Math.abs(dist1) < Math.abs(dist2)) {
                    return dist1;
                } else {
                    return dist2;
                }
            } else {
                int minDist = Math.min(Math.abs(nums[closestIndex - 1] + nums[closestIndex] + nums[closestIndex + 1] - target),
                                Math.min(Math.abs(nums[closestIndex - 2] + nums[closestIndex - 1] + nums[closestIndex] - target),
                                        Math.abs(nums[closestIndex] + nums[closestIndex + 1] + nums[closestIndex + 2] - target))
                                );
                if (minDist == Math.abs(nums[closestIndex - 1] + nums[closestIndex] + nums[closestIndex + 1] - target)) {
                    return nums[closestIndex - 1] + nums[closestIndex] + nums[closestIndex + 1];
                } else if (minDist == Math.abs(nums[closestIndex - 2] + nums[closestIndex - 1] + nums[closestIndex] - target)) {
                    return nums[closestIndex - 2] + nums[closestIndex - 1] + nums[closestIndex];
                } else {
                    return nums[closestIndex] + nums[closestIndex + 1] + nums[closestIndex + 2];
                }
            }
        } else {
            int insertIndex = -closestIndex;
            if (insertIndex == 1) {
                return nums[0] + nums[1] + nums[2];
            } else if (insertIndex == nums.length) {
                return nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            } else if (insertIndex == 2 || insertIndex == nums.length - 1){
                int dist1 = nums[insertIndex - 2] + nums[insertIndex - 1] + nums[insertIndex] - target;
                if (nums.length == 3) {
                    return 0;
                }

                int dist2 = nums[insertIndex - 1] + nums[insertIndex] + nums[insertIndex + 1] - target;
                if (Math.abs(dist1) < Math.abs(dist2)) {
                    return dist1;
                } else {
                    return dist2;
                }
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Pro16 pro = new Pro16();
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(pro.threeSumClosest(nums, target));
    }
}
