package leetcode.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Pro94 {

    public TreeNode root = null;

    public List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return res;
        }

        inorderTraversalInner(root);

        return res;
    }

    /**
     * 递归求解
     * @param root
     */
    private void inorderTraversalInner(TreeNode root) {

        if (root == null) {
            return ;
        }

        inorderTraversalInner(root.left);
        res.add(root.val);
        inorderTraversalInner(root.right);
    }

    /**
     * 迭代求解: 中序遍历
     * @param root
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);  // Add after all left children
                cur = node.right;
            }
        }

        return list;
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

        Pro94 bTree = new Pro94();

        //input : 1 2 0 5 0 0 3 0 4 0 0
        /**
          1
         / \
         2  3
         \  \
         5  4
         */
        TreeNode root = bTree.createBinaryTree(bTree.root);

//        bTree.traverse(root);

        List<Integer> list =  bTree.inorderTraversal(root);

        System.out.println(list);
    }
}
