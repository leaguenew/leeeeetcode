package leetcode.Tree;

import java.util.List;
import java.util.Scanner;

/**
 * 经典
 * 二叉搜索树的最小绝对差
 * 三种算法:
 * 1.参考Pro783，中序遍历存储到列表中；遍历列表；（需要存储空间，而且慢）
 * 2.利用中序递增特性，参考本例的两个代码；
 */
public class Pro530_Minimum_Absolute_Difference_In_BST {

    public TreeNode root = null;

    private int minDis = Integer.MAX_VALUE;

    private int preNodeValue;

    private Boolean firstFlag = false;

    public int getMinimumDifference(TreeNode root) {

        /**
         * 方法一
          */
//        preNodeValue = findMostLeftValue(root);
//
//        inorderTraverse(root);
//
//        return minDis;
        /**
         * 方法二
         */
        inorderTraverse2(root);

        return  minDis;
    }

    private int findMostLeftValue(TreeNode root) {

        if (null == root.left) {
            return root.val;
        }

        return findMostLeftValue(root.left);
    }

    private void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        inorderTraverse(root.left);

        if (preNodeValue != root.val) {
            minDis = Math.min(minDis, root.val - preNodeValue);
            preNodeValue = root.val;
        }

        inorderTraverse(root.right);
    }

    public void inorderTraverse2(TreeNode root) {
        if (null == root) {
            return;
        }

        inorderTraverse2(root.left);

//        if (!firstFlag) {
//            preNodeValue = root.val;
//            firstFlag = true;
//        } else {
//            minDis = Math.min(minDis, root.val - preNodeValue);
//            preNodeValue = root.val;
//        }
//        System.out.println("preNodeValue = " + preNodeValue);
        System.out.println("root.val = " +  root.val);
//        System.out.println("minDis = " +  minDis);

        inorderTraverse2(root.right);
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

    public void traverse(TreeNode root) {
        if (null == root) {
            return;
        }

        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }


    public static void main(String[] args) {

        Pro530_Minimum_Absolute_Difference_In_BST bTree = new Pro530_Minimum_Absolute_Difference_In_BST();

        //input : 5 4 0 0 7 0 0
        /**
          5
         / \
        4  7
         */
        TreeNode root = bTree.createBinaryTree(bTree.root);

//        bTree.traverse(root);
//        bTree.inorderTraverse2(root);


        int res =  bTree.getMinimumDifference(root);

        System.out.println(res);
    }
}
