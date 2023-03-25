package company;


public class Tesla {

    public int solution(String S, int[] C) {
        // Implement your solution here
        int result = 0;
        int point1 = 0, point2 = 0, maxVal = 0, sumVal = 0;
        while(point2 < S.length()) {

            while(point2 < S.length() && S.charAt(point2) == S.charAt(point1)) {
                maxVal = Math.max(maxVal, C[point2]);
                sumVal += C[point2];
                point2++;
            }

            result += sumVal - maxVal;
            point1 = point2;
            sumVal = 0;
            maxVal = 0;
        }

        return result;
    }

    public int solution1(String S, int[] C) {
        // Implement your solution here
        int result = 0;
        int  maxVal = 0, sumVal = 0;
        for(int idxLeft = 0, idxRight = 0; idxRight < S.length(); ) {

            for(; idxRight < S.length() && S.charAt(idxRight) == S.charAt(idxLeft); idxRight++) {
                maxVal = Math.max(maxVal, C[idxRight]);
                sumVal += C[idxRight];
            }

            result += sumVal - maxVal;
            idxLeft = idxRight;
            sumVal = 0;
            maxVal = 0;
        }

        return result;
    }


}
