package com.hzf.jianzhi_offer._009;

import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * <a href="https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">...</a>
 */
public class CQueue {

    private final LinkedList<Integer> stack1;
    private final LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }


    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        int val = -1;
        if (stack1.size() == 0) return val;
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        if (stack2.size() > 0) {
            val = stack2.poll();
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
        }
        return val;
    }
}
/*
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

/*
 * poll()选择返回null，
 * pop()选择抛出异常。
 */
