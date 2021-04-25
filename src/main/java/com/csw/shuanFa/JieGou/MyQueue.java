package com.csw.shuanFa.JieGou;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> outStack;
    private Stack<Integer> inStack;

    public MyQueue() {
        outStack = new Stack<Integer>();
        inStack = new Stack<Integer>();
    }

    private void in2OutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public void push(int element) {
        inStack.push(element);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            this.in2OutStack();
        }
        return outStack.pop();
    }

    public int top() {
        if (outStack.isEmpty()) {
            this.in2OutStack();
        }
        return outStack.peek();
    }
}