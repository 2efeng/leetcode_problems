package com.hzf.jianzhi_offer._024;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Solution {


    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode node, ListNode last) {
        if (node == null) return last;
        ListNode res = reverse(node.next, node);
        node.next = last;
        return res;
    }


}
