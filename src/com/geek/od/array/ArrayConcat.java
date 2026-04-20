package com.geek.od.array;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组拼接
 *
 * 题目描述
 *
 * 现在有多组整数数组，需要将它们合并成一个新的数组。合并规则，从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，如果该行不足固定长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 *
 * 输入描述
 *
 * 第一行是每次读取的固定长度，0<长度<10
 *
 * 第二行是整数数组的数目，0<数目<1000
 *
 * 第3-n行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大
 *
 * 不超过100个元素。
 *
 * 输出描述
 *
 * 输出一个新的数组，用逗号分隔
 *
 * 用例
 *
 * @author: HK意境
 * @date: 2026/4/20 21:06
 * @version: 1.0
 */
public class ArrayConcat {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int readLen = Integer.parseInt(scanner.nextLine());

        int arrayNum = Integer.parseInt(scanner.nextLine());

        List<Stack<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < arrayNum; i++) {
            String[] arrayStr = scanner.nextLine().split(",");
            arrays.add(new Stack<>());
            for (int j = arrayStr.length - 1; j >= 0; j--) {
                arrays.get(i).add(Integer.parseInt(arrayStr[j]));
            }
        }

        System.out.println(concatArrays(readLen, arrays));
    }

    private static String concatArrays(int readLen, List<Stack<Integer>> arrays) {

        List<Integer> res = new ArrayList<>();

        while(!arrays.isEmpty()) {

            for (Stack<Integer> array : arrays) {
                for (int j = 0; j < readLen; j++) {
                    if (!array.isEmpty()) {
                        res.add(array.pop());
                    }
                }
            }

            arrays.removeIf(Stack::isEmpty);
        }

        if (res.isEmpty()) {
            return "";
        }
        return res.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

}
