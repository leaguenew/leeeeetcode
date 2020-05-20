package leetcode.BinarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Pro33 {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0; int r = nums.length - 1;

        while(l <= r) {

            int mid = (l + r) / 2;

            int lv = nums[l];
            int mv = nums[mid];
            int rv = nums[r];

            if (mv == target) {
                return mid;
            } else if (target < mv) {
                if (target >= lv || lv > mv) {
                    r = mid - 1;
                    continue;
                } else {
                    l = mid + 1;
                    continue;
                }
            } else {
                //target > mv
                if (target <= rv || rv < mv) {
                    l = mid + 1;
                    continue;
                } else {
                    r = mid - 1;
                    continue;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {0,1,2,4,5,6,7};


        System.out.println(new Pro33().search(nums, 8));
    }
}
