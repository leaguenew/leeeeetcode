package leetcode;

import java.util.*;

class VO {
    private int a, b,c, d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
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
            if (vo.a == this.a && vo.b == this.b && vo.c == this.c && vo.d == this.d)
                return true;
        }
        return false;
    }

    /**
     * 重写hashcode 方法，返回的hashCode不一样才再去比较每个属性的值
     */
    @Override
    public int hashCode() {
        return a * b * c * d;
    }
}


public class Pro18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Set<VO> set = new HashSet<VO>();
        List<List<Integer>> resList = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                for(int k = j + 1; k < nums.length; k++)
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);

                            Collections.sort(list);

                            VO vo = new VO();
                            vo.setA(list.get(0));
                            vo.setB(list.get(1));
                            vo.setC(list.get(2));
                            vo.setD(list.get(3));
                            set.add(vo);
                        }
                    }

        for(VO vo: set) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(vo.getA());
            list.add(vo.getB());
            list.add(vo.getC());
            list.add(vo.getD());

            resList.add(list);
        }

        return resList;
    }

    public static void main(String[] args) {
        Pro18 pro = new Pro18();

        int[] nums = new int[]{1, 0, -1, 0, -2, 2};

        System.out.println(pro.fourSum(nums, 0));

    }
}
