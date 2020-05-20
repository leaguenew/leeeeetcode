package leetcode.BinarySearch;

public class Pro704 {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int l = 0, r = nums.length - 1, mid;
        while(l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int search1(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }

        return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    private int binarySearchRecursive(int[] arr, int l, int r, int target) {

        if (l > r) {
            return -1;
        }

        int mid = (l + r) >> 1;
        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearchRecursive(arr, l, mid - 1, target);
        } else {
            return binarySearchRecursive(arr, mid + 1, r, target);
        }
    }


    public static void main(String[] args) {
        Pro704 pro = new Pro704();

        int[] arr = new int[]{-1,0,3,5,9,12};

        int pos = pro.search1(arr, 12);

        System.out.println(pos);
    }
}
