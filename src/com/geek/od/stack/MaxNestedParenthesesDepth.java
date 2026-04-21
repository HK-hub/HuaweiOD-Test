package com.geek.od.stack;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * 最大括号深度
 *
 * 题目描述
 *
 * 现有一字符串仅由"("，")", "{","}", "[", "]"六种括号组成。若字符串满足以下条件之一，
 *
 * 则为无效字符串:任一类型的左右括号数量不相等
 *
 * 存在未按正确顺序(先左后右)闭合的括号输出括号的最大嵌套深度，若字符串无效则输出0。
 *
 * 0<=字符串长度<=100000
 *
 * 输入描述
 *
 * 一个只包括(，’)’，’{‘，”}”，[，”]”的字符串
 *
 * 输出描述
 *
 * 整数，最大的括号深度
 *
 * 用例
 *
 * @author: HK意境
 * @date: 2026/4/21 22:03
 * @version: 1.0
 */
public class MaxNestedParenthesesDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(maxDepth(s));
    }

    private static int maxDepth(String s) {

        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        Set<Character> leftBrackets = Set.of('(', '{', '[');
        Map<Character, Character> bracketPairs = Map.of(')', '(', '}', '{', ']', '[');
        for (char c : s.toCharArray()) {
            if (leftBrackets.contains(c)) {
                stack.push(c);
                maxDepth = Math.max(maxDepth, stack.size());
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == bracketPairs.get(c)) {
                        stack.pop();
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }
        return maxDepth;
    }

}
