package HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int idx = in.nextInt();
            int val = in.nextInt();
            if (map.containsKey(idx)) {
                map.put(idx, val + map.get(idx));
            } else {
                map.put(idx, val);
            }
        }
        for(Map.Entry<Integer, Integer> item: map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
