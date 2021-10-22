/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        for (int i = 1; i < n; i ++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (prev == null) {
            return head.next;
        }
        prev.next = slow.next;

        return head;
    }
}
// @lc code=end

