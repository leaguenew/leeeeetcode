package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-20 15:32
 **/
public class Pro56BD {

    public int[][] merge(int[][] intervals) {

        if (null == intervals || intervals[0].length == 0) {
            return null;
        }

        Arrays.sort(intervals, (l, r) -> Integer.compare(l[0], r[0]));
        List<int[]> resList = new ArrayList<>();
        int[] unionInterval = intervals[0];
        for(int i = 0; i < intervals.length ; i++) {
            if (unionInterval[1] < intervals[i][0]) {
                resList.add(unionInterval);
                unionInterval = intervals[i];
            } else {
                unionInterval[1] = Math.max(unionInterval[1], intervals[i][1]);
            }
        }
        resList.add(unionInterval);

        return resList.toArray(new int[resList.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {100,120},
            {1,2},
            {3,9},
            {4,5},
            {3,8},
            {3,7}
        };

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + "," + arr[i][1]);
            System.out.println();
        }
//        Arrays.sort(arr, (l, r) -> Integer.compare(l[0], r[0]));
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        System.out.println();
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + "," + arr[i][1]);
            System.out.println();
        }

//        Pro56BD pro = new Pro56BD();
//        int[][] res = pro.merge(arr);
//        for(int i = 0; i < res.length; i++) {
//            System.out.print(res[i][0] + "," + res[i][1]);
//            System.out.println();
//        }
    }
}
