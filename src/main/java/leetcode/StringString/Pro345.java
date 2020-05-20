package leetcode.StringString;

import java.util.ArrayList;
import java.util.List;

public class Pro345 {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        List<String> vowels = new ArrayList<String>(){
            {
                add("a");
                add("e");
                add("i");
                add("o");
                add("u");
            }
        };
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while(l < r) {
            while(!vowels.contains(String.valueOf(chars[l])) && l < r) {
                l++;
            }
            while (!vowels.contains(String.valueOf(chars[r])) && l < r) {
                r--;
            }
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Pro345 pro = new Pro345();
        System.out.println(pro.reverseVowels("leetcode"));
    }
}
