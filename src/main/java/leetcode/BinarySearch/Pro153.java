package leetcode.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class Pro153 {

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1, mid;
        while (l < r - 1) {

            if (nums[l] < nums[r]) {
                return nums[l];
            }

            mid = l + (r - l) / 2;
            if (nums[l] < nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return Math.min(nums[l], nums[r]);
    }

    public static void main(String[] args) {

        Pro153 pro = new Pro153();

        int a[] = new int[]{3,4,5,-2, -1, 1,2};
//        int a[] = new int[]{-2, -1, 1,2, 3,4,5};
//        int a[] = new int[]{-2};
//        int a[] = new int[]{2, 1};

        int res = pro.findMin(a);

        System.out.println(res);

        Map<String, String> map = new HashMap<String, String>();

        map.put("1", "2");

        System.out.println(map);

        fun(map);

        System.out.println(map);

        int b = 1;

        System.out.println(b);

        fun1(b);

        System.out.println(b);
    }

    public static void fun(Map<String, String> map) {

        Map<String, String> map1 = map;
        map1.put("1", "3");
    }

    public static void fun1(int val) {
        val += 1;
    }
}
