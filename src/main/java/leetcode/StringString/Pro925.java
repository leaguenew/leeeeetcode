package leetcode.StringString;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-21 11:35
 **/
public class Pro925 {

    public boolean isLongPressedName(String name, String typed) {
        if ( (name == null && typed == null) ||
                (name.length() == 0 && typed.length() == 0)) {
            return true;
        }

        if (name.length() > typed.length()) {
            return false;
        }

        int l1 = 0, r1 = l1 + 1, l2 = 0, r2 = l2 + 1;
        while(l1 < name.length() && l2 < typed.length()) {
            if (!name.substring(l1, l1 + 1).equals(typed.substring(l2, l2 +  1)))  {
                return false;
            }
            while(r1 < name.length() && name.substring(l1, l1 + 1).equals(name.substring(r1, r1 + 1))) {
                r1++;
            }
            while(r2 < typed.length() && typed.substring(l2, l2 + 1).equals(typed.substring(r2, r2 + 1))) {
                r2++;
            }
            if ( (r2 - l2) < (r1 - l1) ) {
                return false;
            }
            l1 = r1;
            r1++;
            l2 = r2;
            r2++;
        }

        if (l1 == name.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Pro925 pro = new Pro925();
        System.out.println(pro.isLongPressedName("pyplrz", "ppyypllr"));
    }
}
