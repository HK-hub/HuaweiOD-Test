package com.geek.od.string;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 按单词下标区间翻转文章内容
 * 给定一段英文文章片段，由若干单词组成，单词间以空格间隔，单词下标从0开始。
 *
 * 请翻转片段中指定区间的单词顺序并翻转后的内容。
 *
 * 例如个给定的英文文章片段为"I am a developer"，翻转区间为[0,3]，则输出"developer a am I"。
 *
 * String reverseWords(String s，int start, int end)
 *
 * 输入描述：
 *
 * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，第二个参数为待翻转内容起始单词下标，
 *
 * 第三个参数为待翻转内容最后一个单词下标。
 *
 * 输出描述：
 *
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出
 *
 * 备注：
 *
 * 英文文章内容首尾无空格
 *
 * 示例1：
 *
 * 输入
 *
 * I am a developer
 *
 * 1
 *
 * 2
 *
 * 输出
 *
 * I a am developer
 *
 * @author: HK意境
 * @date: 2026/4/20 22:35
 * @version: 1.0
 */
public class ReverseContent {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        System.out.println(reverseWords(s, start, end));
    }

    public static String reverseWords(String str, int start, int end) {

        String[] words = str.split(" ");

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < start; i++) {
            joiner.add(words[i]);
        }

        for (int i = end; i >= start; i--) {
            joiner.add(words[i]);
        }

        for (int i = end + 1; i < words.length; i++) {
            joiner.add(words[i]);
        }
        return joiner.toString();
    }

}
