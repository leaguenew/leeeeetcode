package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-04 10:02
 **/
public class Pro442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        if (null == nums) {
            return resList;
        }

        for(int i = 0; i < nums.length; i++) {
            nums[ (nums[i] - 1) % nums.length ] += nums.length;
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * nums.length) {
                resList.add(i + 1);
            }
        }

        return resList;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        if (null == nums) {
            return resList;
        }

        for(int i = 0; i < nums.length; i++) {
            //交换位置，把对应的数字放到以数字为下标的数组上
            while(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                resList.add(nums[i]);
            }
        }

        return resList;
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
