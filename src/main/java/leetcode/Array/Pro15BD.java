package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * 解法：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * @author: niuliguo
 * @create: 2020-02-03 23:26
 **/
public class Pro15BD {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return resList;
        }

        Arrays.sort(nums);
        int l, r, len = nums.length;
        for(int i = 0; i < len - 1; i++) {
            if (nums[i] > 0) {
                break;
            }

            //结果去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            l = i + 1;
            r = len - 1;
            while(l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    resList.add(list);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }

        }

        return resList;
    }

    public static void main(String[] args) {
        Pro15BD pro = new Pro15BD();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(pro.threeSum(nums));
    }
}
