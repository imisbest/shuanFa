package com.csw.shuanFa.JieGou;

import java.util.Stack;

public class NiBoLan {
  /*  逆波兰表达式求值
    在反向波兰表示法中计算算术表达式的值, ["2", "1", "+", "3", "*"] -> (2 + 1) * 3 -> 9*/

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                s.push(Integer.valueOf(token));
                continue;
            }

            int a = s.pop();
            int b = s.pop();
            if (token.equals("+")) {
                s.push(b + a);
            } else if (token.equals("-")) {
                s.push(b - a);
            } else if (token.equals("*")) {
                s.push(b * a);
            } else {
                s.push(b / a);
            }
        }
        return s.pop();
    }
}
