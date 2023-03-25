package company.HW;

import java.util.HashMap;
import java.util.Map;

public class S1 {

    public int solution(int[] A) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], true);
        }

        int idx = 1;
        while(map.get(idx) != null && map.get(idx) ) {
            idx++;
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 4, 1, 2};
        S1 s1 = new S1();
        int res = s1.solution(arr);
        System.out.println(res);
    }
}
