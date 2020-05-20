package leetcode.Array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * 双指针
 * @author: niuliguo
 * @create: 2019-12-08 08:59
 **/
public class Pro228 {

    private Map<Integer,Integer> l2r = new HashMap<Integer, Integer>();
    private  List<String> resList = new ArrayList<String>();
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return resList;
        }

        int l, r;
        for(l = 0, r = 0; l < nums.length && r < nums.length - 1; ) {
            if (nums[r + 1] - nums[r] == 1) {
                r++;
            } else {
                if (r == l) {
                    l2r.put(l, l);
                } else {
                    l2r.put(l, r);
                }
                r++;
                l = r;
            }
        }
        l2r.put(l, r);

        for(Map.Entry<Integer, Integer>  map : l2r.entrySet()) {
            if (map.getKey() == map.getValue()) {
                resList.add(String.valueOf(nums[map.getKey()]));
            } else {
                l = map.getKey();
                r = map.getValue();
                StringBuilder sb = new StringBuilder();

                sb.append(String.valueOf(nums[l])).append("->").append(String.valueOf(nums[r]));
                resList.add(sb.toString());
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Pro228 pro = new Pro228();
        int[] nums = new int[]{0,2,3,4,6,8,9};
//        int[] nums = new int[]{0,2,3,4,6,8,9, 14};

        System.out.println(pro.summaryRanges(nums));
    }
}
