package leetcode.Heap;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-22 20:17
 **/
public class Pro1054 {

    class VO {
        private Integer val;
        private Integer cnt;

        public VO(Integer val, Integer cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Integer getCnt() {
            return cnt;
        }

        public void setCnt(Integer cnt) {
            this.cnt = cnt;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> val2Cnt = new HashMap<>();
        for(Integer val: barcodes) {
            if (val2Cnt.get(val) == null) {
                val2Cnt.put(val, 1);
            } else {
                val2Cnt.put(val, val2Cnt.get(val) + 1);
            }
        }

        PriorityQueue<VO> bigHeap = new PriorityQueue<VO>((vo1, vo2) -> (vo2.cnt - vo1.cnt));
        for(Map.Entry<Integer, Integer> map: val2Cnt.entrySet()) {
            bigHeap.add(new VO(map.getKey(), map.getValue()));
        }

        List<Integer> resList = new ArrayList<>();
        while(resList.size() < barcodes.length) {
            VO peek = bigHeap.poll();
            if (resList.size() == 0 || peek.getVal() != resList.get(resList.size() - 1)) {
                resList.add(peek.getVal());
                if (peek.getCnt() > 1) {
                    peek.setCnt(peek.getCnt() - 1);
                    bigHeap.add(peek);
                }
            } else {
                VO peek2 = bigHeap.poll();
                resList.add(peek2.getVal());
                resList.add(peek.getVal());
                if (peek.getCnt() > 1) {
                    peek.setCnt(peek.getCnt() - 1);
                    bigHeap.add(peek);
                }
                if (peek2.getCnt() > 1) {
                    peek2.setCnt(peek2.getCnt() - 1);
                    bigHeap.add(peek2);
                }
            }
        }

        int[] resArr = new int[resList.size()];
        for(int i  = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {
        Pro1054 pro = new Pro1054();
        System.out.println(pro.rearrangeBarcodes(new int[]{1,1,1,2,2,2}));
    }
}
