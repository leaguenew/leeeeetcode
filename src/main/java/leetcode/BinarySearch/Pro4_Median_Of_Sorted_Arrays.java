package leetcode.BinarySearch;

public class Pro4_Median_Of_Sorted_Arrays {

    /**
     * 算法：归并排序
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] numsNew = new int[len1 + len2];
        if (0 == len1 && 0 == len2) {
            return Integer.MIN_VALUE;
        } else if (0 == len2) {
            return len1 % 2 == 0 ? (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2 : (nums1[len1 / 2]) / 2;
        } else if (0 == len1) {
            return len2 % 2 == 0 ? (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2 : (nums2[len2 / 2]) / 2;
        }

        int i = 0, j = 0, idx = 0; //i for nums1, j for nums2, idx for numsNew
        while (idx < len1 + len2) {
            if (i == len1) {
                while(j < len2) {
                    numsNew[idx++] = nums2[j++];
                }
                break;
            }
            if (j == len2) {
                while(i < len1) {
                    numsNew[idx++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] > nums2[j]) {
                numsNew[idx++] = nums2[j++];
            } else {
                numsNew[idx++] = nums1[i++];
            }
        }

        return idx % 2 == 0 ? (numsNew[idx / 2 - 1] + numsNew[idx / 2]) / 2 :
                (numsNew[idx / 2]);
    }

    /**
     * log(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        return -1;
    }
}
