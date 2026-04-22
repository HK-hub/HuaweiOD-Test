package com.geek.od.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 求字符串中所有整数的最小和
 *
 * 题目描述
 *
 * 输入字符串s，输出s中包含所有整数的最小和。
 *
 * 说明:
 *
 * 字符串s，只包含a-zA-Z+-;合法的整数包括
 *
 * 1正整数一个或者多个0-9组成，如0230021022)负整数负号-开头，数字部分由一个
 *
 * 或者多个0-9组成，如-0 -012 -23 -00023
 *
 * 输入描述
 *
 * 包含数字的字符串
 *
 * 输出描述
 *
 * 所有整数的最小和
 *
 * 用例
 *
 * @author: HK意境
 * @date: 2026/4/21 23:06
 * @version: 1.0
 */
public class MinSumOfStringAllInteger {

    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        String s = line.nextLine();
        System.out.println(minSumOfStringAllInteger(s));
    }

    private static int minSumOfStringAllInteger(String expression) {

        boolean isNegative = false;
        StringBuilder negativeBuffer = new StringBuilder();
        int sum = 0;

        char[] charArray = expression.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // 是否是数字
            char c = charArray[i];
            if (Character.isDigit(c)) {
                if (isNegative) {
                    negativeBuffer.append(c);
                } else {
                    sum += Integer.parseInt(c + "");
                }
            } else {
                if (isNegative) {
                    sum -= Integer.parseInt(negativeBuffer.toString());
                }
                isNegative = false;
                negativeBuffer = new StringBuilder();

                if (c == '-') {
                    isNegative = true;
                }
            }
        }

        return sum;
    }

}
