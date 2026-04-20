package com.geek.od.string;

import java.util.Objects;
import java.util.Scanner;

/**
 * 5、标题:5键键盘的输出
 * 【5键键盘的输出】有一个特殊的 5键键盘，上面有 a,ctrl-c,ctrl-x,ctrl-v,ctrl-a五个键。
 * a键在屏幕上输出一个字母 a;
 * ctrl-c将当前选择的字母复制到剪贴板;
 * ctrl-x将当前选择的 字母复制到剪贴板，并清空选择的字母;
 * ctrl-v将当前剪贴板里的字母输出到屏幕;
 * ctrl-a 选择当前屏幕上所有字母。
 * 注意:
 * 1、剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 * 2、当屏幕上没有字母时，ctrl-a无效
 * 3、当没有选择字母时，ctrl-c和 ctrl-x无效
 * 4、当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
 * 给定一系列键盘输入，输出最终屏幕上字母的数量。
 * 输入描述:
 * 输入为一行，为简化解析，用数字 12345代表 a,ctrl-c,ctrl-x,ctrl-v,ctrl-a五个键的输入，数字用空格分隔
 * 输出描述:
 * 输出一个数字，为最终屏目上字母的数量。
 * 示例:
 * 输入
 * 111
 * 输出
 * 3
 *
 * @author: HK意境
 * @date: 2026/4/20 15:51
 * @version: 1.0
 */
public class FiveKeysKeyboard {

    public static class OperationSystem {

        public String screen = "";

        public String clipboard = "";

        public String selectedString = "";
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opString = scanner.nextLine();
        System.out.println(finalString(new OperationSystem(), opString.split(" ")).length());
    }

    public static String finalString(OperationSystem os, String[] ops) {


        for (String op : ops) {
            switch (op) {
                case "1":
                    inputToScreen(os);
                    break;
                case "2":
                    copyToClipboard(os);
                    break;
                case "3":
                    clip(os);
                    break;
                case "4":
                    pasteFromClipboard(os);
                    break;
                case "5":
                    selectAll(os);
                    break;
            }
        }
        return os.screen;
    }

    private static void selectAll(OperationSystem os) {
        os.selectedString = os.screen;
    }

    private static void pasteFromClipboard(OperationSystem os) {

        if (os.selectedString.isEmpty()) {
            os.screen = os.screen + os.clipboard;
        } else {
            os.screen = os.screen.replaceFirst(os.selectedString, os.clipboard);
        }
    }

    private static void clip(OperationSystem os) {

        if (os.selectedString.isEmpty()) {
            return;
        }
        os.clipboard = os.selectedString;
        os.screen = os.screen.replaceFirst(os.selectedString, "");
        os.selectedString = "";
    }

    private static void copyToClipboard(OperationSystem os) {

        if (os.selectedString.isEmpty()) {
            return;
        }
        os.clipboard = os.selectedString;
    }

    private static void inputToScreen(OperationSystem os) {
        if (os.selectedString.isEmpty()) {
            os.screen += "a";
        } else {
            // 有字母被选择
            os.screen = os.screen.replaceFirst(os.selectedString, "a");
            os.selectedString = "";
        }
    }

}
