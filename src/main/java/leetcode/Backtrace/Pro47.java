package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-01 16:26
 **/
public class Pro47 {

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
    private int size;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || nums.length == 0) {
            return ret;
        }

        size = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for(Integer Int: nums) {
            list.add(Int);
        }
        backtracing(new ArrayList<Integer>(), list);

        processRes(res);
        return ret;
    }

    private void processRes(Set<VO> res) {
        for(VO vo : res) {
            ret.add(vo.getArr());
        }
    }

    private void backtracing(List<Integer> cur, List<Integer> left) {

        System.out.println("cur = " + cur + ", left = " + left);
        if (cur.size() == size && left.size() == 0) {
            res.add(new VO(cur));
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

    public static void main(String[] args) {
        Pro47 pro = new Pro47();
        int[] nums = new int[]{1,1,2};
        System.out.println(pro.permuteUnique(nums));
    }
}
