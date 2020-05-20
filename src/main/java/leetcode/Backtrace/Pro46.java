package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-01 15:31
 **/
public class Pro46 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private int size;

    /**
     * 自己实现
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) {
            return res;
        }

        size = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for(Integer Int: nums) {
            list.add(Int);
        }
        backtracing(new ArrayList<Integer>(), list);

        return res;
    }

    private void backtracing(List<Integer> cur, List<Integer> left) {

        System.out.println("cur = " + cur + ", left = " + left);
        if (cur.size() == size && left.size() == 0) {
            res.add(cur);
            return;
        }

        for(int i = 0; i < left.size(); i++) {
            int temp = left.get(i);
            List<Integer> curNew = new ArrayList<Integer>(cur);
            curNew.add(temp);
            List<Integer> leftNew = new ArrayList<Integer>(left);
            leftNew.remove(i);
            backtracing(curNew, leftNew);
        }
    }


    /**
     * 官方解法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack1(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack1(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack1(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Pro46 pro = new Pro46();
        int[] nums = new int[]{1,1,2};
        System.out.println(pro.permute(nums));
    }
}
