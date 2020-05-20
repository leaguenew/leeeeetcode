package leetcode.BinarySearch;

public class Pro240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (null == matrix || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean flag = false;
        for (int i = 0 ; i < rows; i++) {

            flag = binarySearch(matrix[i], target);

            if (flag) {
                return true;
            }
        }

        return flag;
    }

    private boolean binarySearch(int a[], int target) {

        int l = 0, r = a.length - 1, mid;
        while (l <= r) {

            mid = l + (r - l) / 2;
            if (target == a[mid]) {
                return true;
            } else if (target < a[mid]) {
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Pro240 pro = new Pro240();

        int[][] matrix = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println("res = " + pro.searchMatrix(matrix, 50));

    }
}
