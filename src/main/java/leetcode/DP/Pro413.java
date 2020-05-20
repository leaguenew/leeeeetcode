package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-05 09:47
 **/
public class Pro413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int[][] dp = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = row; column < n; column++) {
                if (row == column || row + 1 == column) {
                    dp[row][column] = 1;
                    continue;
                }
                //第一行特殊处理，后面几行就可以根据前几行的状态判断了
                if (row == 0) {
                    if (dp[row][column - 1] == 0) {
                        dp[row][column] = 0;
                    } else {
                        dp[row][column] = A[column] - A[column - 1] == A[column - 1] - A[column - 2] ? 1 : 0;
                    }
                } else {
                    if (dp[row][column - 1] == 0) {
                        dp[row][column] = 0;
                    } else {
                        if (dp[row - 1][column - 1] == 1 && dp[row - 1][column] == 1) {
                            dp[row][column] = 1;
                        } else if (dp[row - 1][column - 1] == 1 && dp[row - 1][column] == 0) {
                            dp[row][column] = 0;
                        } else {
                            dp[row][column] = A[column] - A[column - 1] == A[column - 1] - A[column - 2] ? 1 : 0;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int column = row + 2; column < n; column++) {
                if (dp[row][column] == 1) {
                    System.out.println(row + " " + column);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /**
     * Time Limit Exceeded
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices1(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int cnt = 0;
        int n = A.length;
        for (int left = 0; left < n - 2; left++) {
            for (int right = left + 2; right < n; right++) {
                if (fun(A, left, right)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean fun(int[] nums, int left, int right) {
        boolean flag = true;
        for(int i = left; i < right - 1; i++) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                continue;
            } else {
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Pro413 pro = new Pro413();
        int[] nums = new int[]{1,2,3,4,6, 8,10,12,14};
        System.out.println(pro.numberOfArithmeticSlices(nums));
        System.out.println(pro.numberOfArithmeticSlices1(nums));
    }
}
