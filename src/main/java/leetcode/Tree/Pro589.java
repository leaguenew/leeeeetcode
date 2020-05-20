package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-06 22:58
 **/
public class Pro589 {

    private List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {

        doPreorder(root);

        return res;
    }

    public void doPreorder(Node root) {

        if(root == null) {
            return;
        }

        res.add(root.val);
        List<Node> children = root.children;
        if(children !=null) {
            for (Node node : children) {
                preorder(node);
            }
        }

    }

    public static void main(String[] args) {

        Pro589 pro = new Pro589();

        Node l3Node1 = new Node(5, null);
        Node l3Node2 = new Node(6, null);
        List<Node> childl2Node1 = new ArrayList<Node>();
        childl2Node1.add(l3Node1);
        childl2Node1.add(l3Node2);

        Node l2Node1 = new Node(3, childl2Node1);
        Node l2Node2 = new Node(2, null);
        Node l2Node3 = new Node(4, null);
        List<Node> childl1Node1 = new ArrayList<Node>();
        childl1Node1.add(l2Node1);
        childl1Node1.add(l2Node2);
        childl1Node1.add(l2Node3);

        Node root = new Node(1, childl1Node1);

        System.out.println(pro.preorder(root));
    }
}
