package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pro938 {

    public TreeNode root = null;

    public List<Integer> res = new ArrayList<Integer>();

    public int rangeSumBST(TreeNode root, int L, int R) {

        inorderTraversalInner(root);

        int sum = 0;

        for (Integer item : res) {
            if (item.intValue() >= L && item.intValue() <= R) {
                sum += item.intValue();
            }
        }

        return sum;
    }

    private void inorderTraversalInner(TreeNode root) {

        if (root == null) {
            return ;
        }

        inorderTraversalInner(root.left);
        res.add(root.val);
        inorderTraversalInner(root.right);
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


    /**
     * 遍历
     * @param node
     */
    public void traverse(TreeNode node){
        if(node != null){
            System.out.println(node.val);//前
            traverse(node.left);
//            System.out.println(node.val);//中
            traverse(node.right);
//            System.out.println(node.val);//后
        }
    }

    public static void main(String[] args) {

        Pro938 bTree = new Pro938();

        //input : 10 5 3 0 0 7 0 0 15 0 18 0 0
        /**
         *   10
             5
             3
             0
             0
             7
             0
             0
             15
             0
             18
             0
             0
         */
        /**
         10
         / \
         5 15
        / \  \
       3  7  18
         */
        TreeNode root = bTree.createBinaryTree(bTree.root);

        bTree.traverse(root);

        System.out.println(bTree.rangeSumBST(root, 7, 15));
    }
}
