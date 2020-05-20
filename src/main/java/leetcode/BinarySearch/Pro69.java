package leetcode.BinarySearch;

public class Pro69 {

    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int mid, l = 0, r = x;
        while(l < r) {

            mid = l + (r - l) / 2;

            if (mid <= x / mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r - 1;
    }

    public static void main(String[] args) {
        Pro69 pro = new Pro69();

//        int res = pro.mySqrt(2147483647);
//        System.out.println("res = " + res );

        for(int i = 0; i < 17; i++){
            int res = pro.mySqrt(i);
            System.out.println("i = " + i + ", res = " + res );
        }

    }
}
