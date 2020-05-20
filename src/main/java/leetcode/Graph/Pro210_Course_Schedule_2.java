package leetcode.Graph;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-05-20 08:42
 **/
public class Pro210_Course_Schedule_2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            resList.add(pre);
            numCourses--;
            List<Integer> posts = graph.get(pre);//post node
            for(Integer post: posts) {
                indegree.set(post, indegree.get(post) - 1);
                if (indegree.get(post) == 0) {
                    queue.add(post);
                }
            }
        }

        if (numCourses == 0) {
            int[] resArr = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                resArr[i] = resList.get(i);
            }
            return resArr;
        } else {
            return new int[0];
        }
    }
}
