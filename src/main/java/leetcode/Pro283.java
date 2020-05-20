package leetcode;

public class Pro283 {

    public void moveZeroes(int[] nums) {

        int h = 0;
        for(int i = h; i < nums.length; i++) {

            if (nums[i] != 0) {
                continue;
            }

            int first0Pos = i;
            for(int j = first0Pos; j < nums.length; j++) {
                if (nums[j] == 0) {
                    continue;
                }

                swap(nums, i, j);
                h = i + 1;
                break;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public void print(int[] a) {
        for(int i = 0 ; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{0,1, 0, 3, 12};

        Pro283 pro = new Pro283();

        pro.moveZeroes(a);

        pro.print(a);
    }
}
