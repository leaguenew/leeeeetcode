package leetcode.HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 算法和347极其一致，这个算法其实是机器学习里面的KNN算法
 */
public class Pro973 {

    /**
     * 统计每个数字的频次，key是数字，value是二维数组行下标
     */
    private Map<Integer, List<Integer>> distinctMap = new TreeMap<Integer, List<Integer>>();

    public int[][] kClosest(int[][] points, int K) {

        if (points == null || points.length == 0) {
            return new int[][]{};
        }

        int rows =  points.length;
        for(int i = 0 ; i < rows; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];


            List<Integer> indexList = distinctMap.get(dis);

            if (indexList == null) {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(i);
                distinctMap.put(dis, tmpList);
            } else {
                indexList.add(i);
                distinctMap.put(dis, indexList);
            }
        }

        int[][] resPoints = new int[K][2];

        //遍历并输出结果
        int j = 0;
        for(Map.Entry<Integer, List<Integer>> item: distinctMap.entrySet()) {
            List<Integer> list = item.getValue();
            for(Integer Int : list) {
                if (K > 0) {
                    resPoints[j++] = points[Int];
                    K--;
                } else {
                    break;
                }
            }
            if (K == 0) {
                break;
            }
        }

        return resPoints;
    }



    public static void main(String[] args) {

        Pro973 pro = new Pro973();

        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};

        int[][] res = pro.kClosest(points, 2);

        for(int i = 0 ; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
