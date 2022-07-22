package com.hzf.jianzhi_offer._006;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * <a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">...</a>
 */
public class Solution {

    //栈  LinkedList
    //递归


    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        reverse(head, res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void reverse(ListNode node, List<Integer> res) {
        if (node == null) return;
        reverse(node.next, res);
        res.add(node.val);
    }


}
