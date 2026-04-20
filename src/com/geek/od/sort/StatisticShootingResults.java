package com.geek.od.sort;

import java.util.*;

/**
 * 统计射击比赛成绩
 *
 * 题目描述
 *
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手ID序列。
 *
 * 条件如下
 *
 * 1.一个选手可以有多个射击成绩的分数，且次序不固定
 *
 * 2.如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手.
 *
 * 3.如果选手的成绩之和相等，则成绩之和相等的选手按照其ID降序排列。
 *
 * 输入描述
 *
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数
 *
 * (2<=N<=100)输入第二行，一个长度为N整数序列，表示参与每次射击的选手ID(0<=ID<=99)
 *
 * 。输入第三行，一个长度为N整数序列，表示参与每次射击的选手对应的成绩(0<=成绩<=100)
 *
 * 输出描述
 *
 * 符合题设条件的降序排名后的选手ID序列。
 *
 * @author: HK意境
 * @date: 2026/4/20 14:59
 * @version: 1.0
 */
public class StatisticShootingResults {

    public static class ShootingScore {
        int id;
        int score;

        public ShootingScore(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] ids = new int[N];
        int[] scores = new int[N];

        String[] idStrArray = scanner.nextLine().split(",");
        for (int i = 0; i < idStrArray.length; i++) {
            ids[i] = Integer.parseInt(idStrArray[i]);
        }

        String[] scoreStrArray = scanner.nextLine().split(",");
        for (int i = 0; i < scoreStrArray.length; i++) {
            scores[i] = Integer.parseInt(scoreStrArray[i]);
        }

        statistic(ids, scores);
    }

    private static void statistic(int[] ids, int[] scores) {

        Map<Integer, List<Integer>> recordMap = new HashMap<>();
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            int score = scores[i];

            if (recordMap.containsKey(id)) {
                recordMap.get(id).add(score);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(score);
                recordMap.put(id, list);
            }
        }

        // 过滤无效成绩
        List<ShootingScore> validScoreList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : recordMap.entrySet()) {
            Integer id = entry.getKey();
            if (entry.getValue().size() >= 3) {
                List<Integer> playerScores = entry.getValue();
                playerScores.sort((o1, o2) -> o2 - o1);
                int sumScore = playerScores.get(0) + playerScores.get(1) + playerScores.get(2);
                validScoreList.add(new ShootingScore(id, sumScore));
            }
        }

        validScoreList.sort((o1, o2) -> {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            }
            return o2.id - o1.id;
        });

        StringJoiner joiner = new StringJoiner(",");
        for (ShootingScore score : validScoreList) {
            joiner.add(score.id + "");
        }
        System.out.println(joiner.toString());
    }


}
