package leetcode.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class Pro199 {

    public TreeNode root = null;

    public List<Integer> rightSideView(TreeNode root) {

        if (null == root) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            int sizeTmp = queue.size();
            while(sizeTmp > 0) {
                if (sizeTmp == 1) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node != null && node.left != null) {
                        queue.add(node.left);
                    }
                    if (node != null && node.right != null) {
                        queue.add(node.right);
                    }
                    break;
                }

                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
                sizeTmp--;
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

        Pro199 bTree = new Pro199();

        //input : 1 2 0 5 0 0 3 0 4 0 0
        /**
                    1
                   / \
                  2  3
                   \  \
                   5  4
         */
        TreeNode root = bTree.createBinaryTree(bTree.root);

        bTree.traverse(root);

        List<Integer> list =  bTree.rightSideView(root);

        System.out.println(list);
    }
}
