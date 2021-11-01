package leetcode.Array;


import java.util.HashMap;

/**
 * 1、统计每个数组的次数
 * 2、双指针遍历前后遍历，直到map里面的value都为1 等同于 (r - l) == map.size()
 * 3、直到map的大小和左右指针的差值一样，说明
 */
public class ProNC41_maxLength {

    public int maxLength (int[] arr) {
        // write code here
        HashMap<Integer, Integer> val2cnt = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if (val2cnt.containsKey(arr[i])) {
                val2cnt.put(arr[i], 1 + val2cnt.get(arr[i]));
            } else {
                val2cnt.put(arr[i], 1);
            }
        }

        int l = 0 , r = arr.length - 1;
        while ( (r - l + 1) != val2cnt.size() ) {
            if (val2cnt.get(arr[l]) == 1 && val2cnt.get(arr[r]) == 1) {
                val2cnt.remove(arr[l]);
                val2cnt.remove(arr[r]);
                l++;
                r--;
            } else if (val2cnt.get(arr[l]) == 1){
                val2cnt.put(arr[r], val2cnt.get(arr[r]) - 1);
                r--;
            } else {
                val2cnt.put(arr[l], val2cnt.get(arr[l]) - 1);
                l++;
            }
        }

        return val2cnt.size();
    }

}
