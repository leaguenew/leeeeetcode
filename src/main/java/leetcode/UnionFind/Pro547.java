package leetcode.UnionFind;

/**
 * @program: risk-leecode-example
 * @description: 并查集-面向过程
 * @author: niuliguo
 * @create: 2020-03-18 16:39
 **/
public class Pro547 {

    public int findCircleNum(int[][] M) {
        if (null == M || M.length == 0) {
            return 0;
        }

        int n = M.length;
        int[] parent = new int[n];
        /**
         * 以下标小的作为根节点
         */
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (M[i][j] == 0) {
                    continue;
                } else {
                    union(parent, i, j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }

        return cnt;
    }

    private void union(int[]parent, int i, int j) {
        int parentI = findParent(parent, i);
        int parentJ = findParent(parent, j);

        parent[parentI] = parentJ;
    }

    private int findParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }



}
