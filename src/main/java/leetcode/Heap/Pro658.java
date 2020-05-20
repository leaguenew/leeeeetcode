package leetcode.Heap;

import java.util.*;

public class Pro658 {

    class VO {
        private int dist;
        private int idx;
        private int val;

        public VO(int dist, int idx, int val) {
            this.dist = dist;
            this.idx = idx;
            this.val = val;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    Queue<VO> queue = new PriorityQueue<VO>(new Comparator<VO>() {
        @Override
        public int compare(VO o1, VO o2) {
            return o2.dist - o1.dist;
        }
    });
    List<Integer> resList = new ArrayList<>();
    List<VO> resVOList = new ArrayList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        for(int i = 0; i < arr.length; i++) {
            int dist = Math.abs(arr[i] - x);
            if (queue.size() < k) {
                queue.add(new VO(dist, i, arr[i]));
            } else {
                if (dist < queue.peek().getDist()) {
                    queue.poll();
                    queue.add(new VO(dist, i, arr[i]));
                }
            }
        }

        while(queue.size() > 0) {
            VO vo = queue.poll();
            resVOList.add(vo);
        }
        Collections.sort(resVOList, new Comparator<VO>() {
            @Override
            public int compare(VO o1, VO o2) {
                return o1.idx - o2.idx;
            }
        });
        for(VO vo: resVOList) {
            resList.add(vo.getVal());
        }

        return resList;
    }

    public static void main(String[] args) {
        Pro658 pro = new Pro658();
        int[] nums = new int[]{0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        System.out.println(pro.findClosestElements(nums, k, x));
    }
}
