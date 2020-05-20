package leetcode.DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: risk-leecode-example
 * @description:
 * 先排序，一二列都是从小到大
 * 1.子问题：整个数组0 ~ n - 1的最长值，跟0 ~ n - 2的最长长度以及pair[i][1]与pair[n - 1][0]大小有关系
 * 2.状态定义：dp[i], 定义0~i pair chain的最长值
 * 3.状态转移：dp[i] = max(dp[i], dp[j] for j in 0 ~ i - 1 +  pair[j][1] < pair[i][0] ? dp[j] + 1 : dp[j])
 * 4.初始状态：dp[*] = 1
 * 5.结果：max(dp[*])
 * @author: niuliguo
 * @create: 2020-04-11 19:28
 **/
public class Pro646_Maximum_Length_of_Pair_Chain {

    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //第二维升序
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                    //第一维升序
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 思路完全错误
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //第二维升序
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                    //第一维升序
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int max = 0 , i , j;
        for(i = 0; i < pairs.length; i++) {
            int maxTmp = 1;
            for(j = i; j < pairs.length; ) {
                int val = pairs[j][1];
                j += 1;
                while(j < pairs.length && pairs[j][0] <= val) {
                    j++;
                }
                if (j < pairs.length) {
                    maxTmp += 1;
                }
            }
            System.out.println("i = " + i + ", j = " + j + ", max = " + max + ", maxTmp =" + maxTmp );
            max = Math.max(max, maxTmp);
        }

        return max;
    }


}
