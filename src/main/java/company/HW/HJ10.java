package company.HW;

import java.util.HashSet;
import java.util.Scanner;

public class HJ10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String inputStr = in.next();
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < inputStr.length(); i++) {
            hashSet.add(inputStr.charAt(i));
        }

        System.out.println(hashSet.size());
    }
}
