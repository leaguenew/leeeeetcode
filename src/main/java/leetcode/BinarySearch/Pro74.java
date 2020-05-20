package leetcode.BinarySearch;

class Point {

    private int row;

    private int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

public class Pro74 {

    private int rows = -1;

    private int columns = -1;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        rows = matrix.length;
        columns = matrix[0].length;
        int l = 0, r = rows * columns - 1, mid;
        while (l <= r) {

            mid = l + (r - l) / 2;
            Point point = convertMidToPoint(mid);
            int row = point.getRow();
            int column = point.getColumn();
            if (target == matrix[row][column]) {
                return true;
            } else if ( target < matrix[row][column]){
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return false;
    }

    private Point convertMidToPoint(int pos) {

        int row = pos / columns;
        int column = pos % columns;

        return new Point(row, column);
    }


    public static void main(String[] args) {
        Pro74 pro = new Pro74();

//        int[][] matrix = new int[][]{
//                {1,   3,  5,  7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };
        int[][] matrix = new int[][]{
                {1,1}
        };
        System.out.println("res = " + pro.searchMatrix(matrix, 2));

    }
}
