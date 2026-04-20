package com.geek.od.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 公司用一个字符串来表示员工的出勤信息
 *
 * absent:缺勒
 * late: 迟到
 * leaveearly: 早退
 * present: 正常上班
 * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下:
 *
 * 缺勤不超过一次，
 * 没有连续的迟到/早退:
 * 任意连续7次考勤，缺勒/迟到/早退不超过3次
 * 输入描述
 * 第一行输入一个整数n，表示有多少个员工
 *
 * 后面n行，每一行输入若干个字符串，表示第i名员工的出勤信息
 *
 * 输出描述
 * 输出n行，每一行表示这名员工能否获得出勤奖，如果可以，则输出“true"，否则输出”false"
 *
 * 示例1
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 输入：
 * 2
 * present
 * present present
 *
 * 输出：
 * true true
 * 示例2
 * 复制代码
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 输入：
 * 2
 * present
 * present absent present present leaveearly present absent
 *
 * 输出：
 * true false
 *
 * 作者：code5bug
 * 链接：https://www.nowcoder.com/discuss/600342118011334656
 * 来源：牛客网
 *
 * @author: HK意境
 * @date: 2026/4/20 21:45
 * @version: 1.0
 */
public class AttendanceInformation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<List<String>> attendanceInfos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            attendanceInfos.add(new ArrayList<>(Arrays.asList(split)));
        }

        System.out.println(canReceivingFullAttendanceAward(attendanceInfos));
    }

    private static String canReceivingFullAttendanceAward(List<List<String>> attendanceInfos) {

        List<Boolean> results = new ArrayList<>();
        for (List<String> attendanceInfo : attendanceInfos) {

            // 缺勤
            boolean hasAbsent = countAbsent(attendanceInfo);
            if (hasAbsent) {
                results.add(false);
                continue;
            }

            // 连续的迟到/早退
            boolean hasContinuousLateOrLeaveEarly = hasContinuousLateOrLeaveEarly(attendanceInfo);
            if (hasContinuousLateOrLeaveEarly) {
                results.add(false);
                continue;
            }

            boolean presentCountInSevenDay = countPresentInSevenDay(attendanceInfo);
            if (!presentCountInSevenDay) {
                results.add(false);
                continue;
            }
            results.add(true);
        }


        return results.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static boolean countPresentInSevenDay(List<String> attendanceInfo) {


        if (attendanceInfo.size() < 7) {
            int count = 0;
            for (String att : attendanceInfo) {
                if (!att.equals("present")) {
                    count++;
                }
            }

            return count <= 3;
        }

        int[] counts = new int[attendanceInfo.size()];
        // dp(n) = dp(n - 1) + (if abnormal 1 else 0)
        counts[0] = attendanceInfo.getFirst().equals("present") ? 0 : 1;
        for (int i = 1; i < attendanceInfo.size(); i++) {
            counts[i] = counts[i - 1] + (attendanceInfo.get(i).equals("present") ? 0 : 1);

            if (i < 7) {
                if (counts[i] > 3) {
                    return false;
                }
            } else {
                if ((counts[i] - counts[i - 7]) > 3) {
                    return false;
                }
            }
        }

        // 查看连续7天内是否满足条件
        return true;
    }

    private static boolean hasContinuousLateOrLeaveEarly(List<String> attendanceInfo) {

        String pre;
        String current;

        for (int i = 1; i < attendanceInfo.size(); i++) {
            pre = attendanceInfo.get(i - 1);
            current = attendanceInfo.get(i);
            if ((pre.equals("late") || pre.equals("leaveearly")) &&
                (current.equals("late") || current.equals("leaveearly"))) {
                return true;
            }
        }

        return false;
    }


    public static boolean countAbsent(List<String> attendanceInfo) {
        int count = 0;
        for (String att : attendanceInfo) {
            if (att.equals("absent")) {
                count++;
            }
        }
        return count > 1;
    }




}
