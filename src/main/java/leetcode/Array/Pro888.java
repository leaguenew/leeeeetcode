package leetcode.Array;

import java.util.Arrays;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-05 17:13
 **/
public class Pro888 {

    /**
     * A: A[i] + A[left] = SumA
     * B: B[j] + B[left] = SumB
     * 交换可得：
     * B[j] + A[left] = (SumA + SumB)/2
     * A[i] + B[left] = (SumA + SumB)/2
     * SumA,SumB,(SumA + SumB)/2都是定值
     * 遍历A[i]，得到A[left]，去B里面找到B[j]即可
     *
     * 时间复杂度 n*logm
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int[] res = new int[2];
        for(int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for(int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int  half = (sumA + sumB) / 2;
        System.out.println("half = " + half);
        for(int i = 0; i < A.length; i++) {
            System.out.println("sum = " + sumA + ", A[i] = " + A[i]);
            int aLeft = sumA - A[i];
            System.out.println("aLeft = " + aLeft);
            int b = half - aLeft;
            System.out.println("b = " + b);
            /**
             * 剪枝，不然超时
             */
            if (b > B[B.length - 1] ||  b < B[0])  {
                continue;
            }
            if (bSearch(B, b) >= 0) {
                res[0] = A[i];
                res[1] = b;
                break;
            }
        }

        return res;
    }

    public int bSearch(int[] arr, int b) {
        int l = 0, r = arr.length - 1;
        int mid = 0;
        while(l <= r) {
            mid = (r + l) / 2;
            System.out.println("l = " + l + ", r = " + r + ", mid = " + mid);
            if (b < arr[mid]) {
                r = mid - 1;
            } else if(b > arr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Pro888 pro = new Pro888();
//        int[] a = new int[]{1,2,5};
//        int[] b = new int[]{2,4};
        int[] a = new int[]{1,1};
        int[] b = new int[]{2,2};
        int[] res = pro.fairCandySwap(a, b);
        System.out.println(res[0] + " " + res[1]);

//        int[] b = new int[]{2,4};
//        System.out.println(pro.bSearch(b, 4));
    }
}
