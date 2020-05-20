package leetcode.Array;

public class Pro713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 1;
            for(int j = i; j < nums.length; j++) {
                if (sum * nums[j] < k) {
                    cnt++;
                    sum *= nums[j];
                } else{
                    break;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Pro713 pro = new Pro713();
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(pro.numSubarrayProductLessThanK(nums, k));
    }
}
