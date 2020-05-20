package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-01 20:48
 **/
public class Pro560 {

    /**
     * 一维数组存储，两层循环
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (sums[j] - sums[i] + nums[i] == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public int subarraySum1(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }

        /**
         * key: sum(0..i)
         * val: count
         */
        Map<Integer, Integer> sum2cnt = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum2cnt.containsKey(sum - k)) { //这句话说明一定有：前缀和（0..j < i） + k == sum，而具体有几个就是map的val值
                cnt += sum2cnt.get(sum - k);
            }
            sum2cnt.put(sum, sum2cnt.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {

    }
}
