package leetcode.BinarySearch;

public class Pro367 {

    public boolean isPerfectSquare(int num) {

        int mid , l = 1, r = num;
        while(l <= r) {
            mid = l + (r - l) / 2;
            if (mid == num /mid && num % mid ==0) {
                return true;
            } else if (mid < num / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Pro367 pro = new Pro367();

        System.out.println("res = " + pro.isPerfectSquare(2));

    }
}
