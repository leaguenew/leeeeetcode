package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-05 14:42
 **/
public class Pro26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int changed = 0;

        for(int left = 0; left < nums.length; ) {
            int right = left;
            while(right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            nums[changed] = nums[left];
            changed += 1;
            left = right;
        }

        return changed;
    }

    public static void main(String[] args) {
        Pro26 pro = new Pro26();
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[]{1,2,3,4};
        System.out.println(nums);
        System.out.println(pro.removeDuplicates(nums));
    }
}
