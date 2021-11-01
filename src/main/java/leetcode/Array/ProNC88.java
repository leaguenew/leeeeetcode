package leetcode.Array;

import java.util.Arrays;

public class ProNC88 {

    public int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);

        return a[a.length - 1];
    }
}
