package leetcode.Tree;


import java.util.ArrayList;
import java.util.List;

public class ProNC45 {

    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> inOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();

    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<int[]> list = new ArrayList<>();

        preOrder(root);
        inOrder(root);
        postOrder(root);
        int[] preOrderArr = new int[preOrderList.size()];
        int[] inOrderArr = new int[inOrderList.size()];
        int[] postOrderArr = new int[postOrderList.size()];
        for(int i = 0; i < preOrderArr.length; i++) {
            preOrderArr[i] = preOrderList.get(i);
            inOrderArr[i] = inOrderList.get(i);
            postOrderArr[i] = postOrderList.get(i);
        }

        list.add(preOrderArr);
        list.add(inOrderArr);
        list.add(postOrderArr);

        return list.toArray(new int[0][]);
    }

    private void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        preOrderList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        postOrderList.add(root.val);
    }

}
