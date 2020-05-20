package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class Pro169 {

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int majorityElement(int[] nums) {

        int limit = nums.length / 2;
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 0 : map.get(nums[i]) + 1);
        }

        for(Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() >= limit) {
                return item.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Pro169 pro = new Pro169();

        int[] a = new int[]{2,2,1,1,1,2,2};

        int res = pro.majorityElement(a);

        System.out.println("res = " + res);
    }
}
