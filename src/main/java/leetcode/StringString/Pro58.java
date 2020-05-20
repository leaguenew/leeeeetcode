package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-23 13:50
 **/
public class Pro58 {

    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && count != 0) {
                break;
            } else if(s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Pro58 pro = new Pro58();
        String str = "hello world";
        System.out.println(pro.lengthOfLastWord(str));
        str = "hello world  ";
        System.out.println(pro.lengthOfLastWord(str));
        str = "       ";
        System.out.println(pro.lengthOfLastWord(str));
        str = "aaa";
        System.out.println(pro.lengthOfLastWord(str));
        str = "a";
        System.out.println(pro.lengthOfLastWord(str));
    }
}
