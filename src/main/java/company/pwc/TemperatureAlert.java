package company.pwc;

import java.util.Scanner;

public class TemperatureAlert {

    private double freezingThresholds;
    private double boilingThresholds;

    private double fluctuationLimit;

    private Status currentStatus, nextStatus;

    private Alert currentAlert;
    private double currentTemperature, nextTemperature;

    public void startTask() {

        System.out.println("Please input the freezing threshold:");
        Scanner sc = new Scanner( System.in );
        freezingThresholds = sc.nextDouble();

        System.out.println("Please input the boiling threshold:");
        boilingThresholds = sc.nextDouble();
        while (boilingThresholds <= freezingThresholds) {
            System.out.println("BoilingThresholds should be larger than freezingThresholds, please input boilingThresholds again:");
            boilingThresholds = sc.nextDouble();
        }

        System.out.println("Please input the fluctuation limit:");
        fluctuationLimit = sc.nextDouble();

        System.out.println("Please input the temperature:");
        currentTemperature = sc.nextDouble();
        currentStatus = getStatus(currentTemperature);
        System.out.println(currentTemperature);
        while (true) {
            System.out.println("Please input the temperature:");
            nextTemperature = sc.nextDouble();
            nextStatus = getStatus(nextTemperature);
            printAndAlert(currentTemperature, currentStatus, nextTemperature, nextStatus);
        }
    }

    private Status getStatus(double currentTemperature) {
        if ( currentTemperature <=  freezingThresholds ) {
            return Status.FREEZING;
        } else if ( boilingThresholds <= currentTemperature ) {
            return Status.BOILING;
        } else {
            return Status.COMMON;
        }
    }

    private void printAndAlert(double currentTemperature, Status currentStatus,
                               double nextTemperature, Status nextStatus) {
        System.out.println(nextTemperature);
        if (currentStatus == Status.COMMON && nextStatus == Status.COMMON) {
            if (currentAlert == Alert.FREEZING && nextTemperature > freezingThresholds + fluctuationLimit) {
                System.out.println(Alert.UNFREEZING.getAlert());
                currentAlert = Alert.UNFREEZING;
            } else if (currentAlert == Alert.BOILING && nextTemperature < boilingThresholds - fluctuationLimit) {
                System.out.println(Alert.UNBOILING.getAlert());
                currentAlert = Alert.UNBOILING;
            }
        } else if (currentStatus == Status.COMMON && nextStatus == Status.FREEZING) {
            if (!Alert.FREEZING.equals(currentAlert)) {
                System.out.println(Alert.FREEZING.getAlert());
                currentAlert = Alert.FREEZING;
            }
        } else if (currentStatus == Status.COMMON && nextStatus == Status.BOILING) {
            if (!Alert.BOILING.equals(currentAlert)) {
                System.out.println(Alert.BOILING.getAlert());
                currentAlert = Alert.BOILING;
            }
        } else if (currentStatus == Status.FREEZING && nextStatus == Status.FREEZING) {

        } else if (currentStatus == Status.FREEZING && nextStatus == Status.COMMON) {
            if (nextTemperature > freezingThresholds + fluctuationLimit) {
                System.out.println(Alert.UNFREEZING.getAlert());
                currentAlert = Alert.UNFREEZING;
            }
        } else if (currentStatus == Status.FREEZING && nextStatus == Status.BOILING) {
            System.out.println(Alert.BOILING.getAlert());
            currentAlert = Alert.BOILING;
        } else if (currentStatus == Status.BOILING && nextStatus == Status.FREEZING) {
            System.out.println(Alert.FREEZING.getAlert());
            currentAlert = Alert.FREEZING;
        } else if (currentStatus == Status.BOILING && nextStatus == Status.COMMON) {
            if (nextTemperature < boilingThresholds - fluctuationLimit) {
                System.out.println(Alert.UNBOILING.getAlert());
                currentAlert = Alert.UNBOILING;
            }
        } else if (currentStatus == Status.BOILING && nextStatus == Status.BOILING) {

        } else {
            System.out.println("error, currentStatus = " + currentStatus + ", nextStatus = " + nextStatus);
        }

        this.currentTemperature = nextTemperature;
        this.currentStatus = nextStatus;
    }

    /**
     * use main to test cases
     * @param args
     */
    public static void main(String[] args) {
        TemperatureAlert alert = new TemperatureAlert();
        alert.startTask();

        /**
         * case1:
         * freezingThresholds: 0
         * boilingThresholds: 10
         * fluctuationLimit: 0.5
         * input:  4.0 1.5 1.0 0.5 0.0 -0.5 0.5 0.0 -1.0 -3.0 1.0 2.0 5.0
         * output: 4.0 1.5 1.0 0.5 0.0 freezing -0.5 0.5 0.0 -1.0 -3.0 1.0 unfreezing 2.0 5.0
         */

        /**
         * case2:
         * freezingThresholds: 0
         * boilingThresholds: 10
         * fluctuationLimit: 0.5
         * input:  5.0 2.0 0.0 0.5 0.6 11 10 9.5 9
         * output: 5.0 2.0 0.0 freezing 0.5 0.6 unfreezing 11 boiling 10 9.5 9 unboiling
         */
    }
}
