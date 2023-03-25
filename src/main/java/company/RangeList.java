package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Task: Implement a class named 'company.RangeList'
 * A pair of integers define a range, for example: [1, 5).
 * This range includes integers: 1, 2, 3, and 4.
 * A range list is an aggregate of these ranges: [1, 5), [10, 11), [100, 201)
 * @ClassName: company.RangeList
 * @Date: 2023-02-19
 * @Author: Liguo Niu
 */
public class RangeList {

    /**
     * the range list which holds all the ranges
     */
    private List<List<Integer>> rangeList = new ArrayList<>();
    /**
     * @description: adds a range to the list
     * @name: add
     * @param toAddRange: the range to be added to the list
     * @return : current range list after add the range
     **/
    public synchronized List<List<Integer>> add(List<Integer> toAddRange) {

        //logger..
        if (!checkParamValid(toAddRange)) {
            //logger...
            return rangeList;
        }

        if (rangeList.size() == 0) {
            rangeList.add(toAddRange);
            return rangeList;
        }

        int newLeft = toAddRange.get(0);
        int newRight = toAddRange.get(1);
        int len = rangeList.size();

        List<List<Integer>> tempRangeList = new ArrayList<>();
        int idx;
        //left
        for(idx = 0; idx < len && rangeList.get(idx).get(1) < newLeft; idx++) {
            tempRangeList.add(rangeList.get(idx));
        }
        //logger..

        //middle
        for(; idx < len && rangeList.get(idx).get(0) <= newRight; idx++) {
            newLeft = Math.min(rangeList.get(idx).get(0), newLeft);
            newRight = Math.max(rangeList.get(idx).get(1), newRight);
        }
        tempRangeList.add(Arrays.asList(newLeft, newRight));
        //logger..

        //right
        for(; idx < len && rangeList.get(idx).get(0) > newRight; idx++) {
            tempRangeList.add(rangeList.get(idx));
        }
        //logger..
        rangeList = tempRangeList;
        return rangeList;
    }

    /**
     * @description: remove a range from the list
     * @name: remove
     * @param toRemovedRange: the range to be removed from the list
     * @return : current range list after remove the range
     **/
    public synchronized List<List<Integer>> remove(List<Integer> toRemovedRange) {

        //logger..
        if (!checkParamValid(toRemovedRange)) {
            //logger..
            return rangeList;
        }
        int leftToBeRemoved = toRemovedRange.get(0);
        int rightBeRemoved = toRemovedRange.get(1);
        int len = rangeList.size();
        List<List<Integer>> tempRangeList = new ArrayList<>();

        for(int idx = 0; idx < len; idx++) {
            if (rangeList.get(idx).get(1) < leftToBeRemoved) {
                tempRangeList.add(Arrays.asList(rangeList.get(idx).get(0), rangeList.get(idx).get(1)));
            } else if (rangeList.get(idx).get(0) > rightBeRemoved) {
                tempRangeList.add(Arrays.asList(rangeList.get(idx).get(0), rangeList.get(idx).get(1)));
            } else {
                if (rangeList.get(idx).get(0) < leftToBeRemoved) {
                    tempRangeList.add(Arrays.asList(rangeList.get(idx).get(0), leftToBeRemoved));
                }
                if (rangeList.get(idx).get(1) > rightBeRemoved) {
                    tempRangeList.add(Arrays.asList(rightBeRemoved, rangeList.get(idx).get(1)));
                }
            }
        }
        //logger..
        rangeList = tempRangeList;
        return rangeList;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        if (rangeList == null || rangeList.size() == 0) {
            return sb.toString();
        }
        for(List<Integer> range: rangeList) {
            sb.append("[").append(range.get(0)).append(", ").append(range.get(1)).append(") ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    /**
     * @description: check the param is valid
     * @name: checkParamValid
     * @param range: the range to be checked
     * @return : if the param is valid
     **/
    private Boolean checkParamValid(List<Integer> range) {
        if (null == range || range.size() != 2) {
            //logger..
            return false;
        }

        return true;
    }
}
