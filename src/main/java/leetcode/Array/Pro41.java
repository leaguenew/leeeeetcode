package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-04 11:41
 **/
public class Pro41 {

    public int firstMissingPositive(int[] nums) {
        Map<Integer,Integer> val2one = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            val2one.put(nums[i], 1);
        }

        for(int i = 0; i < nums.length; i++) {
            if (val2one.get(i + 1) == null) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    /**
     * 参考Pro442解法
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != (i + 1) && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    public static void main(String[] args) {

    }
}
