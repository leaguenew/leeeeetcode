package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description: 一个长数组，找出出现次数超过一半的数
 * 算法一：1.定义map存储数据的次数，key：arr[i], value: count
 * 算法二：1.计数，O(1)空间复杂度，两个变量count和value
 * @author: niuliguo
 * @create: 2020-04-16 17:30
 **/
public class Keep {

    /**
     * 时间：O(n)，空间：O(n)
     * @param arr
     * @return
     */
    public int fun(int[] arr) {
        if (null == arr  || arr.length == 0) {
            return -1;
        }

        Map<Integer, Integer> val2cnt = new HashMap<>();//扩容
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            val2cnt.put(arr[i], val2cnt.getOrDefault(arr[i], 0) + 1);
            if (val2cnt.get(arr[i]) >= (arr.length >> 1)) {
                return val2cnt.get(arr[i]);
            }
        }

        return -1;
    }

    public int fun1(int[] arr) {
        if (null == arr  || arr.length == 0) {
            return -1;
        }

        int value = arr[0];
        int cnt = 1;
        int len = arr.length;

        for(int i = 1; i < len; i++) {
            if (cnt == 0) {
                value = arr[i];
                cnt++;
            } else if (value == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        Keep keep = new Keep();
        int[] arr = new int[7];
    }
}
