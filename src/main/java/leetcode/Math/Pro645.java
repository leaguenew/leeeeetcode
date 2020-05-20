package leetcode.Math;

public class Pro645 {

    public int[] findErrorNums(int[] nums) {

        int len = nums.length;
        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {

            if (arr[nums[i]] == 1) {
                return new int[]{nums[i], i + 1};
            }

            if (arr[nums[i]] == 0) {
                arr[nums[i]] = 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Pro645 pro = new Pro645();

        int[] nums = new int[]{1,2,2,4};

        System.out.println(pro.findErrorNums(nums)[0]);
        System.out.println(pro.findErrorNums(nums)[1]);
        System.out.println(pro.findErrorNums(nums)[2]);
        System.out.println(pro.findErrorNums(nums)[3]);
    }
}
