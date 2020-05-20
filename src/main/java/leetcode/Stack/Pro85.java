package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-29 12:51
 **/
public class Pro85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        Arrays.fill(heights, 0);
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }
        //保存heights下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = -1;
        for(int i = 0; i < heights.length; i++) {

            while (stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                int cur = stack.pop();
                maxArea = Math.max((i - stack.peek() - 1) * heights[cur], maxArea);
            }
            stack.push(i);

//            System.out.println("stack = " + stack + ", maxArea = " + maxArea);
        }

        if (stack.size() > 1) {
            int rightIndex = stack.peek(); //rightIndex == heights.length - 1
            while (stack.size() > 1) {
                int cur = stack.pop();
                maxArea = Math.max((rightIndex - stack.peek()) * heights[cur], maxArea);

            }
        }

        return maxArea;
    }

}
