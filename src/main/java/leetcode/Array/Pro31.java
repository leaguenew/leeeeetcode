package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description: https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
 * 算法：
 * 1.先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；
   2.再找出另一个最大索引 l 满足 nums[l] > nums[k]；
   3.交换 nums[l] 和 nums[k]；
   4.最后翻转 nums[k+1:]。
   解释：
   1.我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的大数与前面的小数交换，就能得到一个更大的数。比如 123456，
    将 5 和 6 交换就能得到一个更大的数 123465。
   2.我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：在尽可能靠右的低位进行交换，需要从后向前查找
   3.将一个尽可能小的大数与前面的小数交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
   4.将大数换到前面后，需要将大数后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；
然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列

 * @author: niuliguo
 * @create: 2020-03-01 11:51
 **/
public class Pro31 {

    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        int k = nums.length - 1;
        boolean flag = false;
        for(int i = k - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                flag = true;
                break;
            }
        }
        if (k == nums.length - 1 && !flag) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int l = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }

        swap(nums, l, k);

        reverse(nums, k + 1, nums.length - 1);
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    private void reverse(int[] nums, int start , int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Pro31 pro = new Pro31();
//        pro.nextPermutation(new int[]{1,3,2});
        pro.nextPermutation(new int[]{3,2,1});
    }
}
