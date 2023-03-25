package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro1272 {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> resList = new ArrayList<>();
        int leftToBeRemoved = toBeRemoved[0];
        int rightBeRemoved = toBeRemoved[1];
        int len = intervals.length;
        for(int idx = 0; idx < len; idx++) {
            if (intervals[idx][1] < leftToBeRemoved) {
                resList.add(Arrays.asList(intervals[idx][0], intervals[idx][1]));
            } else if (intervals[idx][0] > rightBeRemoved) {
                resList.add(Arrays.asList(intervals[idx][0], intervals[idx][1]));
            } else {
                if (intervals[idx][0] < leftToBeRemoved) {
                    resList.add(Arrays.asList(intervals[idx][0], leftToBeRemoved));
                }
                if (intervals[idx][1] > rightBeRemoved) {
                    resList.add(Arrays.asList(rightBeRemoved, intervals[idx][1]));
                }
            }
        }

        return resList;
    }
}
