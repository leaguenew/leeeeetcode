package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-07 20:57
 **/
public class Pro257 {

    private List<String> ret = new ArrayList<String>();
    private List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<String> binaryTreePaths(TreeNode root) {

        preOrder(root, new ArrayList<Integer>());
        process(resList);

        return ret;
    }

    private void preOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println("list = " + list);
            resList.add(list);
        }

        preOrder(root.left, new ArrayList<Integer>(list));
        preOrder(root.right, new ArrayList<Integer>(list));

        return;
    }

    private void process(List<List<Integer>> resList) {

        for(List<Integer> list: resList) {
            if (list.size() == 1) {
                ret.add(String.valueOf(list.get(0)));
            } else {
                StringBuilder sb = new StringBuilder();
                int i;
                for(i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i)).append("->");
                }
                sb.append(list.get(i));
                ret.add(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
//        Pro257 pro = new Pro257();
//        TreeNode l3Node1 = new TreeNode(5);
//        TreeNode l2Node1 = new TreeNode(2, null, l3Node1);
//        TreeNode l2Node2 = new TreeNode(3, null, null);
//        TreeNode root = new TreeNode(1, l2Node1, l2Node2);
//        System.out.println(pro.binaryTreePaths(root));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        List list1 = new ArrayList<>(list);
        list1.add(4);
        res.add(new ArrayList<>(list1));
        System.out.println(res.size());
        System.out.println(res);
    }
}
