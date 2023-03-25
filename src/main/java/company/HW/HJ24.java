package company.HW;

import java.util.Scanner;

public class HJ24 {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++) {
//            int height = in.nextInt();
//            arr[i] = height;
//        }
//
//        int max = 0;
//        for(int i = 0; i < arr.length; i++) {
//            int preLen = lengthOfLIS(arr, 0 ,i);
//            int postLen = lengthOfLDS(arr, i , arr.length - 1);
////            System.out.println("preLen=" + preLen + "||postLen=" + postLen);
//            max = Math.max(max, postLen + preLen - 1);
//        }
//
//        System.out.println(max);
//    }


    public static int lengthOfLIS(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        if (end == 0 || start == nums.length - 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[start] = 1;
        int maxans = 1;
        for (int i = start; i <= end; i++) {
            dp[i] = 1;
            for (int j = start; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static int lengthOfLDS(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[start] = 1;
        int maxans = 1;
        for (int i = start; i <= end; i++) {
            dp[i] = 1;
            for (int j = start; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,6,5,4,3,2,1,0};
//        int[] nums = new int[]{4,3,2,1,0};
        System.out.println(lengthOfLIS(nums, 0, 2));
        System.out.println(lengthOfLDS(nums, 2, 9));

    }
}
