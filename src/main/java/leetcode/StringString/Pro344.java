package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-09-14 21:59
 **/
public class Pro344 {

    public void reverseString(char[] s) {

        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }

        char temp;
        for(int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        Pro344 pro = new Pro344();

//        char []chars = new char[]{'H','a','n','n','a','h'};
        char []chars = new char[]{'a', 'b', 'c', 'd', 'e'};

        System.out.println(chars);

        pro.reverseString(chars);

        System.out.println(chars);
    }
}
