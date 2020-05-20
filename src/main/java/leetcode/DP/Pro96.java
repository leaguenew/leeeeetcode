package leetcode.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-20 10:30
 **/
public class Pro96 {

    /**
     * 方法一：强行递归
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return func(n);
    }

    private int func(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += func(i - 1) * func(n - i);
        }

        return sum;
    }


    /**
     * 方法二：记忆化递归
     * @param n
     * @return
     */
    private Map<Integer, Integer> map = new HashMap<>();
    public int numTrees1(int n) {
        map.put(0, 1);
        map.put(1, 1);
        return func1(n);
    }

    private int func1(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += func1(i - 1) * func1(n - i);
        }
        map.put(n, sum);

        return sum;
    }



    /**
     * 方法三：动态规划
     * 1.子问题：数字n有多少种组合，由1~n为根的组合求和
     * 2.状态定义：dp[i]: 以i为跟的组合个数，那么n个根的总个数就是fun[n] = sum(dp[i]) (1<=i<=n)
     * 3.状态转移：dp[i] = dp[i - 1] * dp[n - i] ? 不对，dp[i] = fun[i - 1] * fun[n - i], fun[n] = sum(fun[i - 1] * fun[n - i]) (1<=i<=n)
     * 4.fun[0] = 1, fun[1] = 1;
     * 5.输出：fun[n]
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        int[] fun = new int[n + 1];
        fun[0] = 1;
        fun[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                fun[i] += fun[j - 1] * fun[i - j];
            }
        }

        return fun[n];
    }


    public static void main(String[] args) {

    }
}
