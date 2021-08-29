package com.csw.algorithm.JieGou;

import java.util.Stack;

public class YouXiaoKuoHao {
    /*给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'，
    判定是否是有效的括号序列。括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，
    但 "([)]" 则是无效的括号。*/

    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isValid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']');
    }
}
