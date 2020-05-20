package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * 这道题涉及到三个点：
 * 1.遍历二叉树，怎么遍历都行，前中后。（递归）
 * 2.根据一个根节点，来计算其所有节点的和。（递归）
 * 3.给定一个数组，找出出现频次最多的数，形成数组返回。（方法一、哈希表统计然后遍历；方法二：排序 + 双指针）
 *
 * @author: niuliguo
 * @create: 2019-12-07 22:24
 **/
public class Pro508 {

    private List<Integer> res = new ArrayList<Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {

        if (root == null) {
            return null;
        }

        preOrder(root);
        return process(res);
    }

    private void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        int sum = root.val + treeSumFromRoot(root.left) + treeSumFromRoot(root.right);
        res.add(sum);

        return;
    }

    /**
     * 计算根节点下所有树节点的和
     * @param root
     * @return
     */
    private int treeSumFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + treeSumFromRoot(root.left) + treeSumFromRoot(root.right);
    }

    public int[] process(List<Integer> res) {
        Map<Integer, Integer> val2cnt = new HashMap<Integer, Integer>();
        int maxCnt = 0;
        for(Integer Int : res) {
            if (val2cnt.get(Int) == null) {
                val2cnt.put(Int, 1);
            } else {
                val2cnt.put(Int, val2cnt.get(Int) + 1);
            }
            if (val2cnt.get(Int) > maxCnt) {
                maxCnt = val2cnt.get(Int);
            }
        }

        List<Integer> ret = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> map : val2cnt.entrySet()) {
            if(map.getValue() == maxCnt) {
                ret.add(map.getKey());
            }
        }
        int[] retArr = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }

        return retArr;
    }

    public static void main(String[] args) {
//        TreeNode l2Node1 = new TreeNode(2, null, null);
//        TreeNode l2Node2 = new TreeNode(-3, null, null);
//        TreeNode root = new TreeNode(5, l2Node1, l2Node2);
//
//        Pro508 pro = new Pro508();
//        System.out.println(pro.treeSumFromRoot(root));
//        System.out.println(pro.findFrequentTreeSum(root));
    }
}
