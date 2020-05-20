package leetcode.Backtrace;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-06 19:53
 **/
public class Pro40 {

    class VO {

        private List<Integer> arr;

        public VO(List<Integer> arr) {
            this.arr = arr;
        }

        public List<Integer> getArr() {
            return arr;
        }

        /**
         * 如果对象类型是User,先比较hashcode，一致的场合再比较每个属性的值
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (this == obj)
                return true;
            if (obj instanceof VO) {
                VO vo = (VO) obj;

                // 比较每个属性的值 一致时才返回true
                List<Integer> arrTemp = vo.arr;
                boolean flag = true;
                for(int i = 0; i < arrTemp.size(); i++) {
                    if (arrTemp.get(i) == this.arr.get(i)) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }

                return flag;
            }
            return false;
        }

        /**
         * 重写hashcode 方法，返回的hashCode不一样才再去比较每个属性的值
         */
        @Override
        public int hashCode() {
            int res = 1;
            for(int i = 0; i < arr.size(); i++) {
                res *= arr.get(i);
            }
            return res;
        }
    }

    private Set<VO> res = new HashSet<VO>();
    private List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>>  combinationSum2(int[] candidates, int target) {

        if (null == candidates || candidates.length == 0) {
            return ret;
        }

        Arrays.sort(candidates);
        List<Integer> left = new ArrayList<Integer>();
        for(Integer Int: candidates) {
            left.add(Int);
        }
        backtracing(new ArrayList<Integer>(), left, target);

        processRes(res);
        return ret;
    }

    private void processRes(Set<VO> res) {
        for(VO vo : res) {
            ret.add(vo.getArr());
        }
    }

    private void backtracing(List<Integer> cur, List<Integer> left, int target) {

        int sum = sumFun(cur);
        if (sum == target) {
            res.add(new VO(cur));
            return;
        }
        if (sum > target) {
            return;
        }

        for(int i = 0; i < left.size(); i++) {
            List<Integer> curTemp = new ArrayList<Integer>(cur);
            curTemp.add(left.get(i));
            List<Integer> leftTemp = new ArrayList<Integer>();
            if (left.size() - i >= 2) {
                leftTemp.addAll(left.subList(i + 1, left.size()));
            }
            backtracing(curTemp, leftTemp, target);
        }
    }

    private int sumFun(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int sum = 0;
        for(Integer Int: list) {
            sum += Int;
        }

        return sum;
    }

    public static void main(String[] args) {
        Pro40 pro = new Pro40();
//        int[] nums = new int[]{2,3,6,7};
//        int target = 7;
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(pro.combinationSum2(nums, target));
    }


}
