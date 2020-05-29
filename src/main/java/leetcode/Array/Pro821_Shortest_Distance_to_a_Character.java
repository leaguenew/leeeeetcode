package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        Map<Integer, Integer> pre2post = new TreeMap<>();
        Arrays.fill(arr, -1);
        int pre = -1, post = -1;
        for(int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                arr[i] = 0;
                post = i;
                pre2post.put(pre, post);
                pre = post;
            }
        }

        int size = pre2post.size();
        System.out.println("size = " + size);
        for(Map.Entry<Integer, Integer> entry: pre2post.entrySet()) {
            pre = entry.getKey();
            post = entry.getValue();
            System.out.println("pre = " + pre + ", post  = " + post);
            if (pre + 1 == post) {
                continue;
            } else if (pre == -1) {
                //前特殊情况
                for(int i = 0; i < post; i++) {
                    arr[i] = post - i;
                }
            } else {
                //正常逻辑
                for(int i = pre + 1; i < post; i++) {
                    if (i - pre >= post - i) {
                        //后半部分
                        arr[i] = post - i;
                    } else {
                        arr[i] = i - pre;
                    }
                }
            }
        }
        //后特殊情况
        for(int i = post + 1; i < len; i++) {
            arr[i] = i - post;
        }
        return arr;
    }

    public static void main(String[] args) {
        Pro821_Shortest_Distance_to_a_Character pro = new Pro821_Shortest_Distance_to_a_Character();
        String S = "eeaaaloveleetcodeaaaaaaaee";
        char C = 'e';
        int[] res = pro.shortestToChar(S, C);
        for(Integer item: res) {
            System.out.println(item);
        }
    }
}
