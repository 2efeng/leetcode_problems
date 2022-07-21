package com.hzf.jianzhi_offer._030;

import java.util.LinkedList;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * <a href="https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/">...</a>
 */
public class MinStack {
    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        min = Math.min(x, min);
        minStack.push(min);
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        if (minStack.isEmpty()) min = Integer.MAX_VALUE;
        else min = minStack.peek();
    }

    public int top() {
        if (stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int min() {
        return min;
    }

}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
