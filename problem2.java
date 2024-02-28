
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

public class problem2 {

    public static void main(String[] args) {

        //Integer.MAX_VAL = 2147483647;
        //[9]
        //[1,9,9,9,9,9,9,9,9,9]

        ListNode l6 = new ListNode(3);
        ListNode l5 = new ListNode(4, l6);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);


        // System.out.println(convertListNodeToNum(l4));
        // System.out.println(convertListNodeToNum(l1));

        // System.out.println(convertNumToListNode(BigInteger.valueOf(807)));
        System.out.println(new problem2().addTwoNumbers(l1, l4));
    }

    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // brute force: convert the lostnodes to two numbers, add them and conver the
        // result to listnode
        BigInteger i = convertListNodeToNum(l1);
        BigInteger j = convertListNodeToNum(l2);


        return convertNumToListNode(i.add(j));
    }

    public static BigInteger convertListNodeToNum(ListNode node) {
        BigInteger i = BigInteger.valueOf(1);
        BigInteger res = BigInteger.valueOf(0);
        while (node.next != null) {
            res = res.add(BigInteger.valueOf(node.val).multiply(i));
            i = i.multiply(BigInteger.valueOf(10));
            node = node.next;
        }
        res = res.add(BigInteger.valueOf(node.val).multiply(i));
        return res;
    }

    public static ListNode convertNumToListNode(BigInteger i) {
        ListNode node = new ListNode(i.mod(BigInteger.valueOf(10)).intValue());
        if (!i.divide(BigInteger.valueOf(10)).equals(BigInteger.ZERO)) {
            node.next = convertNumToListNode(i.divide(BigInteger.TEN));
        }
        return node;
    }
    */


    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        /*
        starting point:
        two node
        */
        //base case

        /*
        middle point:
        two node, and 1
        two node, and 0
        one node, and 1
        one node, and 0
        */
        if (l1.next == null && l2.next != null) {
            return new ListNode ((l1.val + l2.val)%10, addTwoNumbers((l1.val + l2.val)/10, l2.next));
        } else if (l1.next != null && l2.next == null) {
            return new ListNode ((l1.val + l2.val)%10, addTwoNumbers((l1.val + l2.val)/10, l1.next));
        } else if (l1.next != null && l2.next != null) {
            return new ListNode ((l1.val + l2.val)%10, addTwoNumbers((l1.val + l2.val)/10, l1.next, l2.next));
        } else if (l1.next == null && l2.next == null) {
            if ((l1.val + l2.val) >= 10) {
                return new ListNode((l1.val + l2.val)%10, new ListNode (1));
            } else {
                return new ListNode(l1.val + l2.val);
            }
        }

        return null;
    }
    
    public ListNode addTwoNumbers(int n, ListNode l1, ListNode l2) {
        if (n == 0) {
            return addTwoNumbers(l1, l2);
        } else {
            if (l1.next == null && l2.next != null) {
                return new ListNode ((n + l1.val + l2.val)%10, addTwoNumbers((n + l1.val + l2.val)/10, l2.next));
            } else if (l1.next != null && l2.next == null) {
                return new ListNode ((n + l1.val + l2.val)%10, addTwoNumbers((n + l1.val + l2.val)/10, l1.next));
            } else if (l1.next != null && l2.next != null) {
                return new ListNode ((n + l1.val + l2.val)%10, addTwoNumbers((n + l1.val + l2.val)/10, l1.next, l2.next));
            } else if (l1.next == null && l2.next == null) {
                if ((n + l1.val + l2.val) >= 10) {
                    return new ListNode((n + l1.val + l2.val)%10, new ListNode (1));
                } else {
                    return new ListNode(n + l1.val + l2.val);
                }
            }
        }

        return null;
    }
        
    /*
    end point
    one node, and 1
    one node, and zero
    two node, and 1
    two node, and zero
    */
    
    public ListNode addTwoNumbers(int n, ListNode l) {
        if (l.next == null) {
            if ((n + l.val) >= 10) {
                return new ListNode((n + l.val)%10, new ListNode(1));
            } else {
                return new ListNode(n + l.val);
            }
        } else {
            return new ListNode((n + l.val)%10, addTwoNumbers((n + l.val)/10, l.next));
        }
    }
}
