package leetcode.BinarySearch;

public class Pro35 {

    public int searchInsert(int[] nums, int target) {

        int l = 0 , r = nums.length - 1;
        while(l<=r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Pro35 pro = new Pro35();

        int[] nums = new int[]{1,3,5,6};
        int pos = pro.searchInsert(nums, -1);

        System.out.println(pos);
    }
}
