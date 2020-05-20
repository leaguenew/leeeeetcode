package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-05 17:50
 **/
public class Pro739 {

    public int[] dailyTemperatures(int[] T) {

        if (null == T || T.length == 0) {
            return T;
        }
        int i,j;
        for(i = 0; i < T.length; i++) {
            for(j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    break;
                }
            }
            if (j == T.length) {
                T[i] = 0;
            } else {
                T[i] = j - i;
            }

        }

        return T;
    }

    public int[] dailyTemperatures1(int[] T) {

        /**
         * 最小栈Min stack
         */
        return null;
    }

    public int[] dailyTemperatures2(int[] T) {

        /**
         * 从后往前
         */
        return null;
    }
}
