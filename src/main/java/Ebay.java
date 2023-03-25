public class Ebay {

    public int string2int(String str) throws Exception {

        if (paramCheck(str)) {
            throw new Exception("invalid param str: " + str);
        }

        int res = process(str);
        if (Integer.MIN_VALUE <= res && res <= Integer.MAX_VALUE) {
            return res;
        } else {
            throw new Exception("invalid result. str: " + str);
        }
    }

    private boolean paramCheck(String str) {
        if (null == str || str.length() == 0 || str.length() > 10) {
            return false;
        }
        if (str.startsWith("-")) {
            str = str.substring(1, str.length());
        }
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }

    private int process(String str) {

        boolean isNegative = false;
        if (str.startsWith("-")) {
            isNegative = true;
            str = str.substring(1, str.length());
        }

        Double val = 0.0;
        for(int i = str.length() - 1; i >= 0; i--) {
            val += (str.charAt(i) - '0') * Math.pow(10, str.length() - 1 - i);
        }

        return isNegative ? -val.intValue() : val.intValue();
    }

    public static void main(String[] args) throws Exception {
        Ebay ebay = new Ebay();
        System.out.println(ebay.string2int("-12312"));
        System.out.println(ebay.string2int("12312"));
        System.out.println(ebay.string2int("1231afadf2"));
        System.out.println(ebay.string2int("123456789098765432"));
        System.out.println(ebay.string2int("123456789098765432"));

        String str = new String("1233");
        str.contains("23");
    }
}
