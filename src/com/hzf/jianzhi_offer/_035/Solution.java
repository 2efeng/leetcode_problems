package com.hzf.jianzhi_offer._035;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * <a href="https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/">...</a>
 */
public class Solution {


    public Node copyRandomList(Node head) {
        return null;
    }

    private Node copyNode(Node node) {
        if (node == null) return null;
        Node curr = new Node(node.val);
        curr.next = copyNode(node.next);
        return curr;
    }


}
