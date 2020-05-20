package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-06 17:06
 **/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Pro559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        List<Node> children = root.children;
        int max = 0;
        if (children != null && children.size() > 0) {
            for (Node node : children) {
                max = Math.max(max, maxDepth(node));
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Pro559 pro = new Pro559();

        Node l3Node1 = new Node(21, null);
        List<Node> childl2Node2 = new ArrayList<Node>();
        childl2Node2.add(l3Node1);

        Node l2Node1 = new Node(21, null);
        Node l2Node2 = new Node(22, childl2Node2);
        Node l2Node3 = new Node(23, null);
        List<Node> childl1Node2 = new ArrayList<Node>();
        childl1Node2.add(l2Node1);
        childl1Node2.add(l2Node2);
        childl1Node2.add(l2Node3);

        Node l1Node1 = new Node(11, null);
        Node l1Node2 = new Node(12, childl1Node2);
        Node l1Node3 = new Node(13, null);
        Node l1Node4 = new Node(14, null);
        List<Node> childl0Node0 = new ArrayList<Node>();
        childl0Node0.add(l1Node1);
        childl0Node0.add(l1Node2);
        childl0Node0.add(l1Node3);
        childl0Node0.add(l1Node4);

        Node root = new Node(0, childl0Node0);

        System.out.println(pro.maxDepth(root));

    }
}
