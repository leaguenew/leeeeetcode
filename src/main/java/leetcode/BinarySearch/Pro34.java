package leetcode.BinarySearch;

public class Pro34 {

    private int mostLeft = Integer.MAX_VALUE;
    private int mostRight = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {

        if (nums == null) {
            return new int[]{-1, -1};
        }

        binarySearchRecursive(nums, 0, nums.length - 1, target);
        if (mostLeft > mostRight) {
            return new int[]{-1, -1};
        } else {
            return new int[]{mostLeft, mostRight};
        }
    }

    private void binarySearchRecursive(int[] arr, int l, int r, int target) {

        if (l > r) {
            return;
        }

        int mid = (l + r) >> 1;
        if (arr[mid] == target) {
            if (mid <= mostLeft) {
                mostLeft = mid;
            }
            if (mid >= mostRight) {
                mostRight = mid;
            }
            binarySearchRecursive(arr, l, mid - 1, target);
            binarySearchRecursive(arr, mid + 1, r, target);
        } else if (target < arr[mid]) {
            binarySearchRecursive(arr, l, mid - 1, target);
        } else {
            binarySearchRecursive(arr, mid + 1, r, target);
        }
    }

    public static void main(String[] args) {
        Pro34 pro = new Pro34();

        int[] arr = new int[]{-1,0,3,3,3,12};

        int[] pos = pro.searchRange(arr, 3);

        System.out.println(pos[0] + " " + pos[1]);
    }
}
