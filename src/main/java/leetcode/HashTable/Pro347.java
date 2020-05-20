package leetcode.HashTable;

import java.util.*;

public class Pro347 {

    /**
     * 统计每个数字的频次，key是数字，value是频次
     */
    private Map<Integer, Integer> mapCnt = new TreeMap<Integer, Integer>();

    /**
     * key是频次，value是出现相同频次的list，用TreeMap来按照频次排序，并且通过使用Collections.reverseOrder()可以从大到小遍历key
     */
    private Map<Integer, List<Integer>> mapCntReverse = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());

    private List<Integer> resList = new ArrayList<Integer>();

    public List<Integer> topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return resList;
        }

        //统计频次
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            mapCnt.put(nums[i], mapCnt.get(nums[i]) == null ? 1 : mapCnt.get(nums[i]) + 1);
        }

        //将频次放到TreeMap里面
        List<Integer> tmpList;
        for(Map.Entry<Integer, Integer> item: mapCnt.entrySet()) {
            if (mapCntReverse.get(item.getValue()) == null) {
                tmpList = new ArrayList<Integer>();
                tmpList.add(item.getKey());
                mapCntReverse.put(item.getValue(), tmpList);
            } else {
                tmpList = mapCntReverse.get(item.getValue());
                tmpList.add(item.getKey());
                mapCntReverse.put(item.getValue(), tmpList);
            }
        }

        //遍历并输出结果
        for(Map.Entry<Integer, List<Integer>> item: mapCntReverse.entrySet()) {
            List<Integer> list = item.getValue();
            for(Integer Int : list) {
                if (k > 0) {
                    resList.add(Int);
                    k--;
                } else {
                    break;
                }
            }
            if (k == 0) {
                break;
            }
        }

        return resList;
    }

    public static void main(String[] args) {

        Pro347 pro = new Pro347();

        int[] nums = new int[]{1,1,1,2,2,3};

        System.out.println(pro.topKFrequent(nums, 2));

//        Map<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
//        map.put(3, "c");
//        map.put(4, "d");
//        map.put(5, "e");
//        map.put(1, "a");
//        map.put(2, "b");
//
//
//        for(Map.Entry<Integer, String> kv: map.entrySet()) {
//            System.out.println(kv.getKey() + " " + kv.getValue());
//        }

    }
}
