package com.geek.od.string;

import java.util.*;

/**
 * 描述
 * 对于给定的字符串
 * s
 * s ，我们可以利用其进行加密。
 * 具体地，首先先将
 * s
 * s 进行去重，即如果
 * s
 * s 中存在重复的字母，则只保留第一次出现的字母。随后，从
 * "a"
 * "a" 开始依次在字符串末尾补充
 * s
 * s 中未出现的字母，使得
 * s
 * s 成为一个完整的字母表。
 * 最后，对于给定的明文
 * t
 * t ，我们利用上述字母表进行加密，即对于
 * t
 * t 中的每个字母，替换为
 * s
 * s 构建得到的新字母表中相同位置的字母。
 * 输入描述：
 * 第一行输入一个长度为
 * 1
 * ≦
 * l
 * e
 * n
 * g
 * t
 * h
 * (
 * s
 * )
 * ≦
 * 100
 * 1≦length(s)≦100 ，仅由小写字母构成的字符串
 * s
 * s ，代表待构建的新字母表底串。
 * 第二行输入一个长度为
 * 1
 * ≦
 * l
 * e
 * n
 * g
 * t
 * h
 * (
 * t
 * )
 * ≦
 * 100
 * 1≦length(t)≦100 ，仅由小写字母构成的字符串
 * t
 * t ，代表需要加密的明文。
 * 输出描述：
 * 在一行上输出一个字符串，代表加密后的密文。
 * 示例1
 * 输入：
 * trailblazers
 * attackatdawn
 * 复制
 * 输出：
 * tpptadtpitvh
 * 复制
 * 说明：
 * 在这个样例中，加密的操作如下：
 * ∙
 *
 * ∙ 对
 * s
 * s 进行去重
 * trailb
 * la
 * ze
 * r
 * s
 * trailblazers ，得到
 * trailbzes
 * trailbzes ；
 * ∙
 *
 * ∙ 随后从
 * "a"
 * "a" 开始依次在字符串末尾补充
 * s
 * s 中未出现的字母，得到
 * trailbzes
 * cdfghjkmnopquvwxy
 * trailbzescdfghjkmnopquvwxy ；
 * ∙
 *
 * ∙ 最后，对于
 * t
 * t 中的每个字母，替换为
 * s
 * s 构建得到的新字母表中相同位置的字母。我们可以列出对照表：
 * ∙
 *
 * ∙
 * [
 * abcdefghijklmnopqrstuvwxyz
 * trailbzes
 * cdfghjkmnopquvwxy
 * ]
 * [
 * abcdefghijklmnopqrstuvwxyz
 * trailbzescdfghjkmnopquvwxy
 * ​
 *  ]
 * ∙
 *
 * ∙ 最后，对于
 * t
 * t 中的每个字母，替换为
 * s
 * s 构建得到的新字母表中相同位置的字母，得到
 * tpptadtpitvh
 * tpptadtpitvh 。
 * 示例2
 * 输入：
 * nihao
 * ni
 * 复制
 * 输出：
 * le
 *
 * @author: HK意境
 * @date: 2026/4/20 22:54
 * @version: 1.0
 */
public class StringEncrypt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        System.out.println(encryptString(s, t));
    }

    public static String encryptString(String s, String t) {

        Set<Character> sourceSet = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            sourceSet.add(c);
        }

        StringBuilder sourceBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (!sourceSet.contains(c)) {
                sourceBuilder.append(c);
            }
        }

        StringBuilder encryptMapStringBuilder = new StringBuilder();
        for (char c : sourceSet) {
            encryptMapStringBuilder.append(c);
        }
        encryptMapStringBuilder.append(sourceBuilder);
        String encryptMapString = encryptMapStringBuilder.toString();

        StringBuilder results = new StringBuilder();
        for (char c : t.toCharArray()) {
            int index = (int) (c - 'a');
            char encryptedChar = encryptMapString.charAt(index);
            results.append(encryptedChar);
        }

        return results.toString();
    }

}
