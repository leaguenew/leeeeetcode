package leetcode.Heap;

import java.util.*;

public class Pro373 {
    class VO {
        private int summary;
        private int u;
        private int v;

        public VO(int u, int v) {
            this.summary = u + v;
            this.u = u;
            this.v = v;
        }

        public int getSummary() {
            return summary;
        }

        public void setSummary(int summary) {
            this.summary = summary;
        }

        public int getU() {
            return u;
        }

        public void setU(int u) {
            this.u = u;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }

    Queue<VO> queue = new PriorityQueue<VO>(new Comparator<VO>() {
        @Override
        public int compare(VO o1, VO o2) {
            return o2.summary - o1.summary;
        }
    });
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if (queue.size() < k) {
                    queue.add(new VO(nums1[i], nums2[j]));
                } else {
                    if (queue.peek().summary <= nums1[i] + nums2[j]) {
                        continue;
                    } else {
                        queue.poll();
                        queue.add(new VO(nums1[i], nums2[j]));
                    }
                }
            }
        }

        while(queue.size() > 0) {
            VO vo = queue.poll();
            List<Integer> listTmp = new ArrayList<>();
            listTmp.add(vo.getU());
            listTmp.add(vo.getV());
            resList.add(listTmp);
        }

        Collections.reverse(resList);

        return resList;
    }

    public static void main(String[] args) {
        Pro373 pro = new Pro373();
        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};
        System.out.println(pro.kSmallestPairs(nums1, nums2, 3));
    }
}
