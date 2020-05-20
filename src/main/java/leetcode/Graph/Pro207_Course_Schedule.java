package leetcode.Graph;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description: 判断一个图是有向无环图
 * 1.根据prerequisites构建邻接表graph，记录每个节点的入度数组indegree[]，入度为0的队列queue，
 * 2.将入度为0的节点入队列，并依次出队，同时节点数-1，得到对应出队的节点pre，更新与它想连的post节点的入度（indegree[post]-1）,
 *   对于入度为0的入队列，while循环直到queue为空。
 * 3.判断删除的节点数是不是为空
 * @author: niuliguo
 * @create: 2020-05-19 12:25
 **/
public class Pro207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 1.init data structure
         */
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(numCourses, 0));
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            indegree.set(post, indegree.get(post) + 1);
            graph.get(pre).add(post);
        }

        /**
         * 2.init queue
         */
        for(int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                queue.add(i);
            }
        }

        /**
         * 3.process
         */
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            List<Integer> posts = graph.get(pre);//post node
            for(Integer post: posts) {
                indegree.set(post, indegree.get(post) - 1);
                if (indegree.get(post) == 0) {
                    queue.add(post);
                }
            }
        }

        return numCourses == 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(6, 0));

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Pro207_Course_Schedule pro = new Pro207_Course_Schedule();
        int[][] matrix = new int[][] {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
                {4, 3},
                {1, 4}
        };
        System.out.println(pro.canFinish(5, matrix));
    }
}
