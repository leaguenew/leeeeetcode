package HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ29 {

    private static Map<Character, Character> map1 = new HashMap<>();
    private static Map<Character, Character> map2 = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputStr1 = in.nextLine();
        String inputStr2 = in.nextLine();
        buildMap();
        StringBuffer sb1 = new StringBuffer();
        for(int i = 0; i < inputStr1.length(); i++) {
            sb1.append(map1.get(inputStr1.charAt(i)));
        }
        System.out.println(sb1.toString());
        StringBuffer sb2 = new StringBuffer();
        for(int i = 0; i < inputStr2.length(); i++) {
            sb2.append(map2.get(inputStr2.charAt(i)));
        }
        System.out.println(sb2.toString());
    }

    public static void buildMap() {

        char ch;
        for( ch = 'a'; ch < 'z'; ch++) {
            char nextCh = (char) ( String.valueOf(ch).toUpperCase().charAt(0) + 1);
            map1.put(ch, nextCh);
            map2.put(nextCh, ch);
        }
        map1.put('z', 'A');
        map2.put('A', 'z');
        for( ch = 'A'; ch < 'Z'; ch++) {
            char nextCh = (char) ( String.valueOf(ch).toLowerCase().charAt(0) + 1);
            map1.put(ch, nextCh);
            map2.put(nextCh, ch);
        }
        map1.put('Z', 'a');
        map2.put('a', 'Z');
        for( ch = '0'; ch < '9'; ch++) {
            char nextCh = (char) ( String.valueOf(ch).charAt(0) + 1);
            map1.put(ch, nextCh);
            map2.put(nextCh, ch);
        }
        map1.put('9', '0');
        map2.put('0', '9');

    }
}
