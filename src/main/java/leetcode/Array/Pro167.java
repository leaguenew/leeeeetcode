package leetcode.Array;

/**
 * todo:1.可以用二分查找来实现； 2.未写入blog
 */
public class Pro167 {

    public int[] twoSum(int[] numbers, int target) {

        if (null == numbers || numbers.length == 0) {
            return null;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        Pro167 pro = new Pro167();

        int[] arr = new int[]{2, 7, 11, 15};

        int[] res = pro.twoSum(arr, 9);

        for (int item: res) {
            System.out.println(item);
        }
    }
}
