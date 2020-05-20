package leetcode.HashTable;

import java.util.Arrays;

/**
 * 多重解法：https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
 * 排序
 * 大顶堆
 * 快速排序的思想
 */
public class Pro215BD {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        System.out.println(nums);

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Pro215BD pro = new Pro215BD();

        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};

        System.out.println(pro.findKthLargest(nums, 4));
    }
}
