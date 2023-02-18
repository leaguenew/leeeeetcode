package HW;

import java.util.HashSet;
import java.util.Scanner;

public class HJ9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        String str = String.valueOf(a);
        HashSet<Character> hashSet = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(int i = str.length() - 1; i >= 0; i--) {
            if (hashSet.contains(str.charAt(i))) {
                continue;
            } else {
                sb.append(str.charAt(i));
                hashSet.add(str.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
