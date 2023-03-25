package company;

public class Ctrip2 {

    private double BIANJIEZHI = 0.0000001;

    public double sqrt(double val) {

        if (val <= 0) {
            //logger....
            return -1; //valid
        }
        if (val == 1) {
            return 1;
        }

        if ( val > 0 && val < 1) {

        } else {

        }

        double leftVal = 0, rightVal = val , midVal = 0;
        while(valid(leftVal , rightVal)) {

            midVal = (leftVal + rightVal) / 2.0;
            if (midVal == val / midVal) {
                return midVal;
            } else if (midVal < val / midVal) {
                leftVal = midVal;
            } else {
                rightVal = midVal;
            }
        }

        return midVal;
    }

    private boolean valid(double leftVal, double rightVal) {
        if (Math.abs(leftVal - rightVal) <= BIANJIEZHI) {
            return false;
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
         Ctrip2 ctrip = new Ctrip2();

         //case 1: valid input
//         double input = 4.0;
//         double res = ctrip.sqrt(input);
//         System.out.println(res);
//
//         //case 2: invalid input
//        input = -1000;
//        res = ctrip.sqrt(input);
//        System.out.println(res);
//
//        //case 3:  valid input2
//        input = 8;
//        res = ctrip.sqrt(input);
//        System.out.println(res);
//
//        //case 4:  valid input3
//        input = 15.111111;
//        res = ctrip.sqrt(input);
//        System.out.println(res);

        //case 5:  valid input4
        double input = 2;
        double res = ctrip.sqrt(input);
        System.out.println(res);

    }
}
