import java.util.ArrayList;
import java.util.List;

public class CP {

    private List<String> resList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        if (null == s || s.length() == 0 || s.length() > 12 ) {
            return resList;
        }

        int len = s.length();
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                //
                for (int k = j + 1; k < len; k++) {
                    //
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (valid(s1) && valid(s2) && valid(s3) && valid(s4)) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(s1).append(".").append(s2).append(".").append(s3).append(".").append(s4);
                        resList.add(sb.toString());
                    }
                }
            }
        }

        return resList;
    }

    private boolean valid(String str) {

        if (str.length() == 0) {
            return false;
        }

        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }
        if (str.length() > 3) {
            return false;
        }
        int val = Integer.parseInt(str);
        if (0 <= val && val <= 255) {
            return true;
        } else {
            return false;
        }
    }





    public static void main(String[] args) {

//        Integer.MIN_VALUE;
        CP cp = new CP();
        String str = "101023";
        List<String> list = cp.restoreIpAddresses(str);
        System.out.println(list);
    }
}
