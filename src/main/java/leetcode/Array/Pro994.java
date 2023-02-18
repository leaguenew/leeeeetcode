package leetcode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro994 {

    class Point {
        public int row;
        public int col;

        public Point(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public boolean isAll0(int[][] grid) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isNo1(int[][] grid) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean has1(int[][] grid) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isNo2(int[][] grid) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    return false;
                }
            }
        }

        return true;
    }


    public int orangesRotting(int[][] grid) {
        if (isAll0(grid) || isNo1(grid)) {
            return 0;
        }
        if (isNo2(grid)) {
            return -1;
        }


        List<Point> badOrangeList = new ArrayList<>();
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    badOrangeList.add(new Point(row, col));
                }
            }
        }
        int cnt = 0;
        Queue<Point> queue = new LinkedList<>();
        for(Point point : badOrangeList) {
            queue.add(point);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean changed = false;
            while (size > 0) {
                Point pointTemp = queue.poll();
                size--;
                int row = pointTemp.row;
                int col = pointTemp.col;
                //up
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    changed = true;
                    grid[row - 1][col] = 2;
                    queue.add(new Point(row - 1, col));
                }
                //down
                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    changed = true;
                    grid[row + 1][col] = 2;
                    queue.add(new Point(row + 1, col));
                }
                //left
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    changed = true;
                    grid[row][col - 1] = 2;
                    queue.add(new Point(row, col - 1));
                }
                //right
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    changed = true;
                    grid[row][col + 1] = 2;
                    queue.add(new Point(row, col + 1));
                }
            }//while
            if (changed) {
                cnt++;
            } else {
                break;
            }
        }//while


        if (has1(grid)) {
            return -1;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][] {
//                {2,1,1},
//                {1,1,0},
//                {0,1,1}
//        };
        int[][] grid = new int[][] {
                {1,2}
        };
        Pro994 pro994 = new Pro994();
        int res = pro994.orangesRotting(grid);
        System.out.println(res);
    }
}
