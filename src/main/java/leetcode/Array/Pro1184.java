package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-09 23:34
 **/
public class Pro1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (null == distance || distance.length == 0) {
            return 0;
        }

        int distTotal = 0;
        int origin  = start;
        while( (start % distance.length) != destination) {
            distTotal += distance[start % distance.length];
            start++;
        }

        int dist1 = distTotal;
        while ( (start % distance.length) != origin) {
            distTotal += distance[start % distance.length];
            start++;
        }

        return Math.min(dist1, distTotal - dist1);
    }
}
