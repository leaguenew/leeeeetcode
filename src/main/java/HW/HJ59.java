package HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ59 {

    static class Value {
        int freq;
        int pos;

        public Value(int freq, int pos) {
            this.freq = freq;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Map<Character, Value> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), new Value(map.get(str.charAt(i)).freq + 1, i));
            } else {
                map.put(str.charAt(i), new Value(1, i));
            }
        }
        int res = Integer.MAX_VALUE;
        for(Map.Entry<Character,Value> item: map.entrySet()) {
            if (item.getValue().freq == 1) {
                res = Math.min(res, item.getValue().pos);
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(str.charAt(res));
        }
    }
}
