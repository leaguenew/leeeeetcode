package company.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String inputStr = in.next();
        Map<Character, Integer> char2val = buildMap();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            if ('0' <= ch && ch <= '9') {
                sb.append(ch);
            } else if ('a' <= ch && ch <= 'z') {
                sb.append(char2val.get(ch));
            } else if ('A' <= ch && ch <= 'Z') {
                sb.append(processUpperChar(inputStr.charAt(i)));
            }
        }

        System.out.println(sb.toString());
    }

    public static Map<Character, Integer> buildMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 2);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 3);
        map.put('g', 4);
        map.put('h', 4);
        map.put('i', 4);
        map.put('j', 5);
        map.put('k', 5);
        map.put('l', 5);
        map.put('m', 6);
        map.put('n', 6);
        map.put('o', 6);
        map.put('p', 7);
        map.put('q', 7);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 8);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 9);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);

        return map;
    }

    public static char processUpperChar(char ch) {
        if (ch == 'Z') {
            return 'a';
        } else {
            return (char) (String.valueOf(ch).toLowerCase().charAt(0) + 1);
        }
    }
}
