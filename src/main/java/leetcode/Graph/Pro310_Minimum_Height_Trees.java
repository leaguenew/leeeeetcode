package leetcode.Graph;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-05-20 09:04
 **/
public class Pro310_Minimum_Height_Trees {

    /**
     * @program: risk-leecode-example
     * @description:
     * 1.构建邻接表
     * 2.从每一个点遍历求得最高深度，并记录
     * 3.找到最小的深度集合
     * 结果：超时，思路不是很准确
     **/
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

    /**
     * 分析：
     * 1.越往里的节点越容易成为最小高度树的根节点
     * 2.从边缘开始找到出度为1的节点，进队列，不断bfs，直到队列为空
     * 算法步骤：
     * 1.建立表graph，建立度数组degree
     * 2.建立队列，并初始化队列（将度为1的节点入队）；
     * 3.bfs，while + for模型，出队列，degree减少，对于度为1的入队列，记录本次循环所有出队的节点，直到最后一次循环就是结果
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 2) {
            for(int i = 0; i < n; i++) {
                res.add(i);
            }

            return res;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        Queue<Integer> queue  = new LinkedList<>();
        Arrays.fill(degree, 0);
        for(int i = 0; i < edges.length; i++) {
            int pre = edges[i][0];
            int post = edges[i][1];
            degree[pre]++;
            degree[post]++;
            graph.get(pre).add(post);
            graph.get(post).add(pre);
        }

        for(int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                degree[cur]--;
                List<Integer> posts = graph.get(cur);
                for(Integer post: posts) {
                    degree[post]--;
                    if (degree[post] == 1) {
                        queue.add(post);
                    }
                }
            }
        }

        return res;
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
        System.out.println(pro.findMinHeightTrees1(6, edges));

    }
}
