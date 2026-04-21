package com.geek.od.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 整数对最小和
 *
 * 题目描述
 *
 * 给定两个整数数组array1、array2，数组元素按升序排列，假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素并对取出的所有元素求和，计算和的最小值。
 *
 * 注意:
 *
 * 两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素
 *
 * 输入描述
 *
 * 输入两行数组array1、array2，每行首个数字为数组大小size(0<size<=100)
 *
 * 0<array1[i]<=1000
 *
 * 0<array2[i]<=1000
 *
 * 接下来一行为正整数k
 *
 * 0<k<=array1.size()*array2.size()
 *
 * 输出描述
 *
 * 满足要求的最小和
 *
 * @author: HK意境
 * @date: 2026/4/21 22:17
 * @version: 1.0
 */
public class MinOfIntegerPairSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String array1String = scanner.nextLine();
        String array2String = scanner.nextLine();
        Integer k = Integer.parseInt(scanner.nextLine());

        String[] array1 = array1String.split(" ");
        Integer array1Len = Integer.parseInt(array1[0]);
        int[] array1Int = new int[array1Len];
        for (int i = 0; i < array1Len; i++) {
            array1Int[i] = Integer.parseInt(array1[i + 1]);
        }

        String[] array2 = array2String.split(" ");
        Integer array2Len = Integer.parseInt(array2[0]);
        int[] array2Int = new int[array2Len];
        for (int i = 0; i < array2Len; i++) {
            array2Int[i] = Integer.parseInt(array2[i + 1]);
        }

        System.out.println(minOfIntegerPairSum(array1Int, array2Int, k));
    }

    private static int minOfIntegerPairSum(int[] array1, int[] array2, Integer k) {

        List<Integer> pairs = new ArrayList<>();
        for (int i : array1) {
            for (int j : array2) {
                pairs.add(i + j);
            }
        }
        Collections.sort(pairs);

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += pairs.get(i);
        }

        return sum;
    }

}
