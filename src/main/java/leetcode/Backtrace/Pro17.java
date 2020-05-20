package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-30 10:08
 **/
public class Pro17 {

    private Map<String, String> digit2String = new HashMap<String, String>(){ {
            put("2" , "abc");
            put("3" , "def");
            put("4" , "ghi");
            put("5" , "jkl");
            put("6" , "mno");
            put("7" , "pqrs");
            put("8" , "tuv");
            put("9" , "wxyz");
        }
    };

    private List<String> res = new ArrayList<String>();
    private int size = 0;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        size = digits.length();

        backtracing("", digits);

        return res;
    }

    /**
     * 定义回溯函数：cur是当前的字符串，digits是剩下需要遍历的数字
     */
    private void backtracing(String cur, String digits) {
        //递归临界条件
        if (digits.length() == 0 && cur.length() == size) {
            res.add(cur);
            return;
        }

        //遍历所有数字
        for(int i = 0; i < digits.length(); i++) {
            //找到数字对应的字母串
            String chars = digit2String.get(digits.substring(i, i + 1));
            //循环一次添加到cur上，然后递归进行下面的搜素
            for(int j = 0; j < chars.length(); j++) {
                String temp = cur + chars.substring(j, j + 1);
                backtracing(temp, digits.substring(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        Pro17 pro = new Pro17();
        System.out.println(pro.letterCombinations("234"));
    }
}
