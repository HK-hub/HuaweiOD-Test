package com.geek.od.dynamicPlan;

import java.util.*;

/**
 * 题目描述
 * 有一个数列A[n]，从A[0]开始每一项都是一个数字，数列中A[n+1]都是A[n]的描述，其中A[0]=1，规则如下：
 * A[0]:1
 * A[1]:11 含义其中A[0]=1是1个1 即11，表示A[0]从左到右连续出现了1次1
 * A[2]:21 含义其中A[1]=11是2个1 即21， 表示A[1]从左到右连续出现了2次1
 * A[3]:1211 含义其中A[2]从左到右是由一个2和一个1组成 即1211，表示A[2]从左到右连续出现了一次2又连续出现了一次1
 * A[4]:111221 含义A[3]=1211 从左到右是由一个1和一个2两个1 即111221，表示A[3]从左到右连续出现了一次1又连续出现了一次2又连续出现了2次1
 * 输出第n项的结果
 * 0<= n <=59
 * 输入描述
 * 数列第n项 0<= n <=59
 * 输出描述
 * 数列内容
 * 示例1
 * 输入
 * js 体验AI代码助手 代码解读复制代码4
 *
 * 输出
 * js 体验AI代码助手 代码解读复制代码111221
 *
 * 作者：芒猿君
 * 链接：https://juejin.cn/post/7260024054065627194
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: HK意境
 * @date: 2026/4/20 21:30
 * @version: 1.0
 */
public class SequenceDescription {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<String> sequence = new ArrayList<>();
        sequence.add("1");
        for (int i = 1; i <= n; i++) {

            sequence.add(getSequenceValue(sequence.get(i - 1)));
        }

        System.out.println(sequence.get(n));
    }

    private static String getSequenceValue(String sequence) {

        StringBuilder res = new StringBuilder();

        char current = sequence.charAt(0);
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (current == sequence.charAt(i)) {
                count++;
            } else {
                res.append(count).append(current);
                current = sequence.charAt(i);
                count = 1;
            }
        }
        res.append(count).append(current);

        return res.toString();
    }



}
