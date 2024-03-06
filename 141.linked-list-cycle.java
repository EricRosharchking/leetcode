/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode one = head;
        ListNode two = head;
        while (two.next != null && two.next.next!= null && one.next != null) {
            two = two.next.next;
            one = one.next;
            if (two == one) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

