package leetcode.StringString;

import java.util.ArrayList;
import java.util.List;

public class Pro168 {
    public String convertToTitle(int columnNumber) {

        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int num = (columnNumber - 1) % 26 + 1;
            sb.append( (char) (num + 'A' - 1));
            columnNumber  = (columnNumber - num) / 26;
        }


//        sb.append( (char) (columnNumber + 'A' - 1));


        return  sb.reverse().toString();
    }

    public static void main(String[] args) {
        Pro168 pro168 = new Pro168();
        System.out.println(pro168.convertToTitle(2147483647));
        System.out.println(pro168.convertToTitle(701));
    }
}
