package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * 解法：四个边界 + 两套循环（while + 4个for循环）
 * @author: niuliguo
 * @create: 2020-02-05 23:06
 **/
public class Pro54 {

    private List<Integer> resList = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return resList;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(true) {
            //left -> right
            for(int i = left; i <= right; i++) {
                resList.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }
            //up -> down
            for(int i = up; i <= down; i++) {
                resList.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            //right -> left
            for(int i = right; i >= left; i--) {
                resList.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }
            //down -> up
            for(int i = down; i >= up; i--) {
                resList.add(matrix[i][left]);
            }
            left++;
            if (right < left) {
                break;
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Pro54 pro = new Pro54();

        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(pro.spiralOrder(matrix));
    }
}
