package leetcode.HashTable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pro217 {

    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();

        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Pro217 pro = new Pro217();

        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};

        System.out.println(pro.containsDuplicate(nums));
    }
}
