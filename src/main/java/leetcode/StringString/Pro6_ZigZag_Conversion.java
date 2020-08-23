package leetcode.StringString;

import java.util.ArrayList;
import java.util.List;

public class Pro6_ZigZag_Conversion {

    public String convert(String s, int numRows) {
        if (null == s || s.length() == 0 || 1 == numRows) {
            return s;
        }

        List<StringBuffer> bufferList = new ArrayList<>();
        for(int i = 0 ; i < numRows; i++) {
            bufferList.add(new StringBuffer());
        }
        int i = 0;
        boolean goDown = true;
        for(char c : s.toCharArray()) {
            bufferList.get(i).append(c);
            if (i == 0) {
                goDown = true;
            }
            if (i == numRows - 1) {
                goDown = false;
            }
            i += goDown ? 1 : -1;
        }

        StringBuffer sb = new StringBuffer();
        for(StringBuffer stringBuffer: bufferList) {
            sb.append(stringBuffer.toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Pro6_ZigZag_Conversion pro6 = new Pro6_ZigZag_Conversion();
        System.out.println(pro6.convert(s, numRows));
    }
}
