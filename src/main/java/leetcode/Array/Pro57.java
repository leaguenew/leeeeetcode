package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class Pro57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resList = new ArrayList<>();
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            resList.add(newInterval);
            return resList.toArray(new int[1][]);
        }

        int newLeft = newInterval[0];
        int newRight = newInterval[1];
        int len = intervals.length;

        int idx;
        //left
        for(idx = 0; idx < len && intervals[idx][1] < newLeft; idx++) {
            resList.add(intervals[idx]);

        }
        //middle
        for(; idx < len && intervals[idx][0] <= newRight; idx++) {
            newLeft = Math.min(intervals[idx][0], newLeft);
            newRight = Math.max(intervals[idx][1], newRight);
        }
        resList.add(new int[]{newLeft, newRight});

        //right
        for(; idx < len && intervals[idx][0] > newRight; idx++) {
            resList.add(intervals[idx]);
        }

        return resList.toArray(new int[resList.size()][]);
    }
}
