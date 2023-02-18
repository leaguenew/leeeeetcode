package HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ40 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if ( ('a' <= str.charAt(i) && str.charAt(i) <= 'z') ||
                    ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')) {
                map.put(1, map.get(1) == null ?  1 : map.get(1) + 1);
            } else if (" ".equals(String.valueOf(str.charAt(i)))) {
                map.put(2, map.get(2) == null ?  1 : map.get(2) + 1);
            } else if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                map.put(3, map.get(3) == null ?  1 : map.get(3) + 1);
            } else {
                map.put(4, map.get(4) == null ?  1 : map.get(4) + 1);
            }
        }
        System.out.println(map.get(1)  == null ? 0 : map.get(1));
        System.out.println(map.get(2)  == null ? 0 : map.get(2));
        System.out.println(map.get(3)  == null ? 0 : map.get(3));
        System.out.println(map.get(4)  == null ? 0 : map.get(4));

    }
}
