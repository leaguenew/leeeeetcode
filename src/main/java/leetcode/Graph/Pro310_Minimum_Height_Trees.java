package leetcode.Graph;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * 1.构建邻接表
 * 2.从每一个点遍历求得最高深度，并记录
 * 3.找到最小的深度集合
 * @author: niuliguo
 * @create: 2020-05-20 09:04
 **/
public class Pro310_Minimum_Height_Trees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /**
         * 1.construct graph
         */
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        /**
         * 2.traverse each node
         */
        Map<Integer, List<Integer>> val2MaxHeight = new HashMap<>();
        Boolean[] visited = new Boolean[n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            int max = maxHeight(i, graph, visited, 1);
            List<Integer> list = val2MaxHeight.getOrDefault(max, new ArrayList<>());
            list.add(i);
            val2MaxHeight.put(max, list);
        }

        /**
         * 3.get the min height gather
         */
        int min = Integer.MAX_VALUE;
        for(Integer val : val2MaxHeight.keySet()) {
            min = Math.min(min, val);
        }

        return val2MaxHeight.get(min);
    }

    private int maxHeight(int val, List<List<Integer>> graph, Boolean[] visited, int height) {
        if (visited[val])  {
            return height;
        }

        visited[val] = true;
        List<Integer> posts = graph.get(val);
        int max = 0;
        for(Integer post: posts) {
            max = Math.max(max, maxHeight(post, graph, visited, height + 1));
        }

        return max;
    }

    public static void main(String[] args) {
        Pro310_Minimum_Height_Trees pro = new Pro310_Minimum_Height_Trees();
        int[][] edges = new int[][]{
                {0,3},
                {1,3},
                {2,3},
                {4,3},
                {5,4}
        };
        System.out.println(pro.findMinHeightTrees(6, edges));

    }
}
