import java.util.HashSet;
import java.util.Set;

/**
 * @className: WeWork
 * @description:
 * badaf -> bdf
 * 1.需求分析 ✅
 * 2.算法设计 ✅
 * 3.coding ✅
 * 4.单测 ✅
 * 5.分析复杂度
 */
public class WeWork {

    /**
     * @method: process
     * @param str： bcdfbd
     * @return: 最长不包含重复字符的子串长度 ： bcdf
     */
    public int process(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        int  left, right, len = str.length();
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        int res = 0;
        for(left = 0; left < len; left++) {
            if (set.contains(chars[left])) {
                set.remove(chars[left]);
                continue;
            }
            for(right = left; right < len; right++) {
                if (!set.contains(chars[right])) {
                    set.add(chars[right]);
                } else {
                    break;
                }
            }
            res = Math.max(res, right - left);
        }
        //xiaoming.zhu@wework.cn

        return res;
    }

    public static void main(String[] args) {
        WeWork weWork = new WeWork();
        System.out.println(weWork.process("bcdfbd"));
        System.out.println(weWork.process("abcdfbd"));
        System.out.println(weWork.process(""));
        System.out.println(weWork.process(null));
        System.out.println(weWork.process("a"));
        System.out.println(weWork.process("aaaaa"));
    }
}
