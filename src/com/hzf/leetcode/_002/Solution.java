package com.hzf.leetcode._002;

/**
 * AddTwoNumbers
 * 2. 两数相加（中等）
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 *  ② --> ④ --> ③
 *  ⑤ --> ⑥ --> ④
 *  ---------------
 *  ⑦ --> 〇 --> ⑧
 *
 * 链接：https://leetcode.cn/problems/add-two-numbers
 */

public class Solution {


    public static void main(String[] args) {


    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return  addNums(l1,l2,0);
    }


    public ListNode addNums(ListNode l1, ListNode l2,int offset){
        if (l1 == null && l2 == null){
            if (offset == 0)  return  null;
            return  new ListNode(1,null);
        }
        int l1Val = 0,l2Val = 0;
        if (l1 != null) l1Val = l1.val;
        if (l2 != null) l2Val = l2.val;
        int sum = l1Val + l2Val + offset;
        if (sum >= 10) {
            sum = sum - 10;
            offset = 1;
        }else {
            offset = 0;
        }
        ListNode l1Next = null,l2Next = null;
        if (l1 != null) l1Next = l1.next;
        if (l2 != null) l2Next = l2.next;
        return new ListNode(sum,addNums(l1Next,l2Next,offset));
    }





}
