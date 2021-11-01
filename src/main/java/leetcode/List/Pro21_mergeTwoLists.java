package leetcode.List;

/**
 * 算法一：递归
 *
 * 算法二：迭代
 */
public class Pro21_mergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        if (l1.val <= l2.val) {
            ListNode tmp = mergeTwoLists(l1.next, l2);
            l1.next = tmp;
            return l1;
        } else {
            ListNode tmp = mergeTwoLists(l1, l2.next);
            l2.next = tmp;
            return l2;
        }
    }
}
