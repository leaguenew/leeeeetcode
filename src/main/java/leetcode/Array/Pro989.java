package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-24 01:50
 **/
public class Pro989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int nums = 1;
        int temp = K;
        while(temp/10 != 0) {
            temp = temp/10;
            nums++;
        }
        int[] B = new int[nums];
        temp = K;
        nums = 0;
        while(temp/10 != 0) {
            B[nums++] = temp % 10;
            temp = temp/10;
        }
        B[nums] = temp % 10;
        reverseArray(A);
        print(A);
        print(B);

        int i = 0,  j = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(i < A.length && j < B.length) {
            list.add(A[i] + B[j]);
            i++;
            j++;
        }
        if ( i == A.length ) {
            for (int h = A.length; h < B.length; h++) {
                list.add(B[h]);
            }
        }
        if ( j == B.length ) {
            for (int h = B.length; h < A.length; h++) {
                list.add(A[h]);
            }
        }
        System.out.println(list);

        System.out.println(list);

        for(i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < 10) {
                continue;
            } else {
                list.set(i + 1, list.get(i + 1) + list.get(i) / 10);
                list.set(i, list.get(i) % 10);
            }
        }
        if (list.get(i) < 10) {
            reverseArrayList(list);
        } else {
            list.add(list.get(i) / 10);
            list.set(i, list.get(i) % 10);
            reverseArrayList(list);
        }
        System.out.println(list);

        return list;
    }

    private void print(int[] arr) {
        for(Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void reverseArrayList(List<Integer> arr) {
        int start = 0, end = arr.size() - 1;
        while(start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    private void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Pro989 pro = new Pro989();
//        int[] A = new int[]{2,1,5};
//        int K = 806;
//        int[] A = new int[]{1,2,0,0};
//        int K = 34;
        int[] A = new int[]{9,9,9};
        int K = 11;
        System.out.println(pro.addToArrayForm(A, K));
    }
}
