package company;

/**
 * string -> int
 */
public class DiDi {

    public int string2int(String str) throws Exception {



        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        if (str.startsWith("-")) {
            if (str.length() > 11) {
                System.out.println("error, str = " + str);
                throw new Exception();
            }
        } else {
            if (str.length() > 10) {
                System.out.println("error, str = " + str);
                throw new Exception();
            }
        }

        Long val = process(str);
        if (val >= min && val < max) {
            return val.intValue();
        } else {
            System.out.println("error, str = " + str);
            throw new Exception();
        }

    }

    public Long process(String str) {
        long res = 0;
        boolean minos = false;
        if (str.startsWith("-")) {
            minos = true;
            str = str.substring(1, str.length());
        }
        for(int i = str.length() - 1; i >= 0; i--) {
            res += (str.charAt(i) - '0') * Math.pow(10, str.length() - 1 - i);
        }

        return minos ? -res : res;
    }

    public static void main(String[] args) throws Exception {
        DiDi didi = new DiDi();
        System.out.println(didi.string2int("abc"));
        System.out.println(didi.string2int("123"));
        System.out.println(didi.string2int("-123"));
        System.out.println(didi.string2int("-2147483648"));
        System.out.println(didi.string2int("2147483647"));
    }
}
