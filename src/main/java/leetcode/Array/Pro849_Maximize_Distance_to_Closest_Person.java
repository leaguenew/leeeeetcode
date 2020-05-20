package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-11 19:10
 **/
public class Pro849_Maximize_Distance_to_Closest_Person {

    public int maxDistToClosest(int[] seats) {
        if (null == seats || seats.length == 0) {
            return 0;
        }

        int res = 0;
        for(int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                continue;
            }
            //find most left
            int mostLeft = i - 1;
            while (mostLeft >= 0) {
                if (seats[mostLeft] == 1) {
                    break;
                }
                mostLeft--;
            }
            //find most right
            int mostRight = i + 1;
            while (mostRight < seats.length) {
                if (seats[mostRight] == 1) {
                    break;
                }
                mostRight++;
            }
            int minDist = Math.min(mostLeft == - 1 ? Integer.MAX_VALUE : i - mostLeft, mostRight == seats.length ? Integer.MAX_VALUE : mostRight - i);
            res = Math.max(minDist, res);
        }

        return res;
    }
}
