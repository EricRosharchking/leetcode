import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        Node end = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != end) {
                node.next = queue.peek();
            } else {
                end = node.right;
            }
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }

    // public Node connect(Node root) {
    //     if(root==null) return null;
    //     Node cur = root;
    //     Node nextLeftmost = null;

    //     while(cur.left!=null){
    //         nextLeftmost = cur.left; // save the start of next level
    //         while(cur!=null){
    //             cur.left.next=cur.right;
    //             cur.right.next = cur.next==null? null : cur.next.left;
    //             cur=cur.next;
    //         }
    //         cur=nextLeftmost;  // point to next level 
    //     }
    //     return root;
    // }
}
// @lc code=end

