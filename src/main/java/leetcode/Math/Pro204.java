package leetcode.Math;

import java.util.Arrays;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-02 12:10
 **/
public class Pro204 {

    /**
     * 判断小于n的数中有多少是素数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        Boolean[] isPrimes = new Boolean[n];
        Arrays.fill(isPrimes, true);
        for(int i = 2; i < Math.sqrt(n); i++) {
            if (isPrimes[i]) {
                for(int j = 2; j * i < n; j++) {
                    isPrimes[j * i] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }

        return count;
    }


}
