package leetcode.Stack;

import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-05 18:18
 **/
public class Pro84 {

    /**
     * 定义子问题：dp[i][j]: 记录从i 到 j的最小高度
     * 状态转移方程：dp[i][i] = heights[i];  dp[i][j] = min(dp[i][j - 1], height[i])
     *
     * Memory Limit Exceeded
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }

        int len = heights.length;
        int[][] dp = new int[len][len];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = heights[i];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], heights[j]);
                }
                max = Math.max(dp[i][j] * (j - i + 1), max);
            }
        }

        return max;
    }

    /**
     * 暴力求解
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        return 0;
    }

    /**
     * 分治：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    /**
     * 单调栈：单调递增栈
     * 解析：
     * 1.以高度height[i]为高度的最大矩形面积为：[后一个高度比i低的index(右边界) - 前一个高度比i低的index(左边界) - 1] * 当前块的高度
     * 2.维护一个单调递增栈，那么对于每一个height，左边第一个一定是左边界，右边界在破坏单调性的那个高度出现，通过弹栈来计算每个高度的最大棉结。
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }
        //保存heights下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = -1;
        for(int i = 0; i < heights.length; i++) {
            if (stack.peek() == -1) {
                stack.push(i);
                continue;
            }
            if (heights[i] > heights[stack.peek()])  {
                stack.push(i);
            } else {
                while (stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                    int cur = stack.pop();
                    maxArea = Math.max((i - stack.peek() - 1) * heights[cur], maxArea);
                }
                stack.push(i);
            }

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


    public static void main(String[] args) {
        Pro84 pro = new Pro84();
        int[] heights = new int[]{2,1,5,6,2,3};
//        int[] heights = new int[]{1, 1};
//        int[] heights = new int[]{2, 3};
//        int[] heights = new int[]{2, 1, 2};
        System.out.println(pro.largestRectangleArea3(heights));
    }
}
