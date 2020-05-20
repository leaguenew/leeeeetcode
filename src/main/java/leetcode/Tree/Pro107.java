package leetcode.Tree;

import java.util.*;

public class Pro107 {

    public TreeNode root = null;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return res;
        }

        queue.add(root);

        while (queue.size() > 0) {

            List<Integer> list = new ArrayList<Integer>();

            int size = queue.size();

            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    list.add(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }

            if (list.size() > 0) {
                res.add(list);
            }
        }

        Collections.reverse(res);

        return res;
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

        Pro107 bTree = new Pro107();

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

        List<List<Integer>> list =  bTree.levelOrderBottom(root);

        System.out.println(list);
    }
}
