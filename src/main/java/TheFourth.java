import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传染病的传播求解
 * 输入：二维矩阵
 * 2:  阳性
 * 1:  阴性
 * 0: 阻断的环境
 * t->t+1（每个标准单位时间）： 2会将其上下左右四个方向的1变为2
 * 问题：求全局所有1都变为2的最短时间
 * 实现： int findMinTime(int [][]matrix)
 *
 * 例子：{
 * {1,0,1,2},
 * {1,0,1,1},
 * {1,1,1,1},
 * {1,0,1,2},
 * }  6
 * {
 * {1,0,1,2},
 * {1,0,1,1},
 * {1,0,1,1},
 * {1,0,1,2},
 * }  -1
 *
 * queue
 * step1: traverse matrix, queue
 * step2: queue
 * step3:
 */
public class TheFourth {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findMinTime(int [][]matrix) {
        Queue<Point> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        //init
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (2 == matrix[i][j]) {
                    queue.add(new Point(i, j));
                }
            }
        }
        if (queue.isEmpty()) {
            return -1;
        }

        //search
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size > 0) {
                Point point = queue.poll();
                size -= 1;
                int x = point.x;
                int y = point.y;
                if (y - 1 >= 0 && matrix[x][y - 1] == 1) { //left
                    matrix[x][y - 1] = 2;
                    queue.add(new Point(x,  y - 1));
                }
                if (y + 1 <= n - 1 && matrix[x][y + 1] == 1) { // right
                    matrix[x][y + 1] = 2;
                    queue.add(new Point(x,  y + 1));
                }
                if (x - 1 >= 0 && matrix[x - 1][y] == 1) { //up
                    matrix[x - 1][y] = 2;
                    queue.add(new Point(x - 1,  y));
                }
                if (x + 1 <= m - 1 && matrix[x + 1][y] == 1) { //down
                    matrix[x + 1][y] = 2;
                    queue.add(new Point(x + 1,  y));
                }
            }
        }

        //check
        boolean flag = hasOneLeft(matrix);
        if (flag) {
            return -1;
        }

        //return
        return res - 1;
    }

    private boolean hasOneLeft(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (1 == matrix[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TheFourth theFourth = new TheFourth();
        int[][] matrix1 = new int[][]{
                {1,0,1,2},
                {1,0,1,1},
                {1,1,1,1},
                {1,0,1,2}
        };
        System.out.println(theFourth.findMinTime(matrix1));
        int[][] matrix2 = new int[][]{
                  {1,0,1,2},
                  {1,0,1,1},
                  {1,0,1,1},
                  {1,0,1,2}
        };
        System.out.println(theFourth.findMinTime(matrix2));
    }
}

