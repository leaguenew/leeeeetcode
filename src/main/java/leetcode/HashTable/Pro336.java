package leetcode.HashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pro336 {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (words == null || words.length == 0) {
            return res;
        }


        int len = words.length;
        for(int i = 0 ; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                String combine = words[i] + words[j];
                if (isPalindrome(combine)) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String str) {

        if (null == str || str.length() ==0) {
            return true;
        }

        char[] chars = str.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Pro336 pro = new Pro336();

        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};

        System.out.println(pro.palindromePairs(words));
    }
}
