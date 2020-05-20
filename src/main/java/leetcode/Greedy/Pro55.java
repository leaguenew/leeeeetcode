package leetcode.Greedy;

/**
 * @program: risk-leecode-example
 * @description:
 * 贪心画图：开一个数据记录能不能到某个点，时间复杂度O(N^2)
 * @author: niuliguo
 * @create: 2020-02-06 14:13
 **/
public class Pro55 {

    public boolean canJump(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        if (nums[0] == 0 && len == 1) {
            return true;
        }
        if (nums[0] == 0 && len > 1) {
            return false;
        }
        if (nums[0] > 0 && len == 1) {
            return true;
        }
        int[] flag = new int[len];
        boolean changed;
        for(int i = 0; i < len; i++) {
            int stepLen = nums[i];
            int step = 1;
            changed = false;
            while(i + step < len && step <= stepLen) {
                flag[i + step]++;
                step++;
                changed = true;
            }
            //没有改变不能结束，因为后面还有可能有为1的
            if (!changed) {
                while(i + 1 < len && flag[i + 1] == 0) {
                    i++;
                }
            }
            if (flag[len - 1] != 0) {
                return true;
            }
        }

        if (flag[len - 1] == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Pro55 pro = new Pro55();
        int[] nums = new int[]{1,0,1,0};
        int[] nums1 = new int[]{3,0,8,2,0,0,1};

        System.out.println(pro.canJump(nums));
        System.out.println(pro.canJump(nums1));
    }
}
