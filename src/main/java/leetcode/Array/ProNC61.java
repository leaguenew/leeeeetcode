package leetcode.Array;


import java.util.HashMap;
import java.util.Map;

/**
 * 算法一：
 * 1、key：数值，value：下标；
 * 2、map构成hash表，遍历当前值和差值
 *
 * 算法二：
 * 暴力求解
 */
public class ProNC61 {

    private int[] res = new int[2];
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        if (null == numbers || numbers.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {

            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;

                return  res;
            }

            map.put(numbers[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        ProNC61 pro = new ProNC61();
        int[] arr = new int[]{3,2,4};

        arr = pro.twoSum(arr, 6);
    }
}
