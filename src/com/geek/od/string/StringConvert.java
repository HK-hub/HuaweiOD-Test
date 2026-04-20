package com.geek.od.string;

import java.util.*;

/**
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
 * 输入描述:
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * 输出描述:
 * 输出转换后的字符串。
 * 示例1
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，转换为abc，ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
 * 示例2
 * 输入
 * 12
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abCABc4aB@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每12个字符一组为abCABc4aB@，这个子串中大小写字母都为4个，不做转换，连起来即12abc-abCABc4aB@
 *
 * 作者：yaozi
 * 链接：https://leetcode.cn/discuss/post/niKSMZ/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: HK意境
 * @date: 2026/4/20 14:15
 * @version: 1.0
 */
public class StringConvert {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();

        String result = convertString(str, k);
        System.out.println(result);
    }


    public static String convertString(String str, int k) {

        String[] splits = str.split("-");
        String first = splits[0];

        StringBuilder remainStringBuilder = new StringBuilder();
        for (int i = 1; i < splits.length; i++) {
            String split = splits[i];
            if (Objects.isNull(split) || split.isEmpty() || split.trim().isEmpty()) {
                continue;
            }

            remainStringBuilder.append(split);
        }

        String remainString = remainStringBuilder.toString();
        if (remainString.isEmpty()) {
            return first;
        }

        StringJoiner joiner = new StringJoiner("-");
        joiner.add(first);
        char[] remainArray = remainString.toCharArray();
        for(int i = 0; i < remainArray.length; ) {
            int beginIndex = i;
            int endIndex = Math.min(i + k, remainArray.length);
            String res = doConvert(remainArray, beginIndex, endIndex);
            joiner.add(res);

            i = endIndex;
        }

        return joiner.toString();
    }


    public static String doConvert(char[] array, int beginIndex, int endIndex) {

        int lower = 0;
        int upper = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = beginIndex; i < endIndex; i++) {
            if (Character.isLetter(array[i])) {
                if (Character.isLowerCase(array[i])) {
                    lower++;
                } else if (Character.isUpperCase(array[i])) {
                    upper++;
                }
            }
            sb.append(array[i]);
        }

        if (lower > upper) {
            return sb.toString().toLowerCase();
        } else if (upper > lower) {
            return sb.toString().toUpperCase();
        }

        return sb.toString();
    }


}
