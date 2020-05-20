package leetcode.HashTable;

import java.util.*;

/**
 * 算法和347极其一致
 */
public class Pro692 {

    private Map<String, Integer> mapCnt = new HashMap<String, Integer>();

    private Map<Integer, List<String>> mapCntReverse = new TreeMap<Integer, List<String>>(Collections.reverseOrder());


    private List<String> resList = new ArrayList<String>();

    public List<String> topKFrequent(String[] words, int k) {

        if(null == words || words.length == 0) {
            return resList;
        }

        //统计频次
        for(String str: words) {
            mapCnt.put(str, mapCnt.get(str) == null ? 1 : mapCnt.get(str) + 1);
        }

        //将频次放到TreeMap里面
        List<String> tmpList;
        for(Map.Entry<String, Integer> item: mapCnt.entrySet()) {
            if (mapCntReverse.get(item.getValue()) == null) {
                tmpList = new ArrayList<String>();
                tmpList.add(item.getKey());
                mapCntReverse.put(item.getValue(), tmpList);
            } else {
                tmpList = mapCntReverse.get(item.getValue());
                tmpList.add(item.getKey());
                Collections.sort(tmpList);
                mapCntReverse.put(item.getValue(), tmpList);
            }
        }

        //遍历并输出结果
        for(Map.Entry<Integer, List<String>> item: mapCntReverse.entrySet()) {
            List<String> list = item.getValue();
            for(String str : list) {
                if (k > 0) {
                    resList.add(str);
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
        Pro692 pro = new Pro692();

        String[] strs = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println(pro.topKFrequent(strs, 4));
    }
}
