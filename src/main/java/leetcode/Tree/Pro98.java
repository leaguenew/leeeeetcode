package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pro98 {

    public TreeNode root = null;

    private List<Integer> list = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validRecursion(TreeNode root, long low, long high) {
        if (root == null) return true;

        if (root.val <= low || root.val >= high) return false;

        return validRecursion(root.left, low, root.val) && validRecursion(root.right, root.val, high);
    }

    public boolean isValidBST1(TreeNode root) {

        traverse(root);

        boolean flag = true;

        int i = 0;

        for (i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i + 1)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public void traverse(TreeNode node){

        if (null == node) {
            return;
        }

        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }

        /**
         * 创建二叉树
         */
    private TreeNode createBinaryTree(TreeNode node) {

        Scanner in = new Scanner(System.in);
        //输入节点的值
//        System.out.println("请输入节点的值：");
        int value = in.nextInt();
        if(value != 0){
            node = new TreeNode(value);
            node.left = createBinaryTree(node.left);
            node.right = createBinaryTree(node.right);
        }else{
            node = null;
        }
        return node;
    }

    public static void main(String[] args) {

        Pro98 bTree = new Pro98();

        //input : 1 2 0 5 0 0 3 0 4 0 0
        /**
         1
         / \
         2  3
         \  \
         5  4
         */
        TreeNode root = bTree.createBinaryTree(bTree.root);

        boolean flag =  bTree.isValidBST1(root);

        System.out.println(flag);
    }
}
