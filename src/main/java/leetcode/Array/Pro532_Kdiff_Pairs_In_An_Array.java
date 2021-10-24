package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class Pro532_Kdiff_Pairs_In_An_Array {


    private Map<Integer, Integer> map = new HashMap<>();

    public int findPairs(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (k == Math.abs(nums[j] - nums[i])) {
                    map.put(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j]));
                }
            }
        }

        return map.size();
    }


}
