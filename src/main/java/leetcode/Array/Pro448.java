package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-03 19:13
 **/
public class Pro448 {

    /**
     * 算法一：开一个数据，然后定位，然后遍历，找不到就是空的
     * 算法二：a[a[i]] += n，那么遍历数组，a[i] <= n，那么数字i一定是没出现的
     * 算法三：开一个map
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resList;
        }

        for(int i = 0; i < nums.length; i++) {
            nums[nums[i]] += nums.length;
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                resList.add(nums[i]);
            }
        }

        return resList;
    }

    public static void main(String[] args) {

    }
}
