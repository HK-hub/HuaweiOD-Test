package com.geek.od.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/5382ff24fbf34a858b15f93e2bd85307
 * 来源：牛客网
 *
 * 给定两个字符串 s和 t ，判断 s是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度n ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：时间复杂度
 * 𝑂
 * (
 * 𝑛
 * )
 *
 * O(n) ，空间复杂度
 * 𝑂
 * (
 * 𝑛
 * )
 *
 * O(n)
 *
 * 输入描述:
 * 共两行，第一行为字符串s,  第二行为字符串t
 *
 *
 * 字符串t的长度 1<=n<=500000
 *
 *
 * 字符串s的长度 1<=m<=100
 *
 *
 *
 * 输出描述:
 * 输出true或者是false，true表示是s是t的子序列，false表示s不是t的子序列
 * 示例1
 * 输入
 * abc
 * ahbgdc
 * 输出
 * true
 * 示例2
 * 输入
 * axc
 * ahbgdc
 * 输出
 * false
 *
 * @author: HK意境
 * @date: 2026/4/20 15:32
 * @version: 1.0
 */
public class SubString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String s = in.nextLine();
        String t = in.nextLine();

        System.out.println(isSubString(s, t));
    }

    public static boolean isSubString(String small, String large) {

        Stack<Character> stack = new Stack<>();
        char[] smalls = small.toCharArray();
        for(int i = smalls.length - 1; i >= 0; --i) {
            stack.add(smalls[i]);
        }

        for (char c : large.toCharArray()) {
            if (stack.isEmpty()) {
                return true;
            }
            if (c == stack.peek()) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
