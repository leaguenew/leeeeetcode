package leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-04 10:33
 **/
public class Pro697 {

    private Map<Integer, Integer> val2cnt = new HashMap<>();//key: nums[i], val: cnt
    private List<Integer> list = new ArrayList<>();
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for(int i = 0; i < nums.length; i++) {
            if (val2cnt.get(nums[i]) == null) {
                val2cnt.put(nums[i], 1);
            } else {
                val2cnt.put(nums[i], 1 + val2cnt.get(nums[i]));
            }
        }

        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> map : val2cnt.entrySet()) {
            if (map.getValue() > max) {
                max = map.getValue();
            }
        }

        for(Map.Entry<Integer, Integer> map : val2cnt.entrySet()) {
            if (map.getValue() == max) {
                list.add(map.getKey());
            }
        }

        int min = Integer.MAX_VALUE;
        for(Integer Int : list) {
            int i,j;
            for(i = 0, j = nums.length - 1; i < j;) {
                if (nums[i] != Int) {
                    i++;
                    continue;
                }
                if (nums[j] != Int) {
                    j--;
                    continue;
                }
                break;
            }

            min = Math.min(min, j - i + 1);
        }

        return min;
    }
}
