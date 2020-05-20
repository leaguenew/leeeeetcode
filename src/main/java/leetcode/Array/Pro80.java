package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-05 16:16
 **/
public class Pro80 {

    /**
     * two pointers
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pos = 0;
        for(int left = 0; left < nums.length; ) {
            int right = left;
            while(right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            if (right - left == 1) {
                nums[pos] = nums[left];
                pos++;
            } else if (right - left >= 2) {
                nums[pos] = nums[left];
                nums[pos + 1] = nums[left];
                pos += 2;
            }
//            System.out.println(left + " " + right);
            left = right;
        }

        return pos;
    }

    public static void main(String[] args) {
        Pro80 pro = new Pro80();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int len = pro.removeDuplicates(nums);
        System.out.println(len);
        for(int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
