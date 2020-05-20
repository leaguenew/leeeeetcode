package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
 * @author: niuliguo
 * @create: 2020-03-07 09:51
 **/
public class Pro84 {

    /**
     * 暴力计算，时间复杂度O(N^2)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }

        return maxArea;
    }

    /**
     * 分而治之
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        //找到最小的下标
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    /**
     * 递增栈
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        return 0;
    }
}
