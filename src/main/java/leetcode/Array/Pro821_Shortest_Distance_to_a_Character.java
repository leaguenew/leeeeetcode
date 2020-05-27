package leetcode.Array;

import java.util.Arrays;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-05-27 10:13
 **/
public class Pro821_Shortest_Distance_to_a_Character {

    public int[] shortestToChar(String S, char C) {
        if (null == S || S.length() == 0) {
            return new int[0];
        }

        int len = S.length();
        int[] arr = new int[len];
        Arrays.fill(arr, -1);
        for(int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                arr[i] = 0;
            }
        }

        int pre = -1, post = 0;
        while(post < len) {
            while (arr[post] != 0) {
                post++;
            }
            if (pre == -1) {
                for(int i = 0; i < post; i++) {
                    if (arr[i] != 0) {
                        arr[i] = post - i;
                    }
                }
                pre = post;
                post += 1;
            } else {
                for(int i = pre + 1; i < post; i++) {
                    if (arr[i] != 0) {
                        arr[i] = post - i;
                    }
                }
                pre = post;
                post += 1;
            }
        }
    }
}
