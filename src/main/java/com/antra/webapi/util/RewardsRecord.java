package com.antra.webapi.util;

import java.util.List;

public class RewardsRecord {
    public static String monthlyRewardsRecods(List<Integer> rewards) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rewards.size(); i++) {
            sb.append(monthInit(i) + rewards.get(i) + "\n");
        }
        return sb.toString();
    }

    public static String monthInit(int m) {
        switch (m) {
            case 0:
                return "Jan: ";
            case 1:
                return "Feb: ";
            case 2:
                return "Mar: ";
            case 3:
                return "Apl: ";
            case 4:
                return "May: ";
            case 5:
                return "Jun: ";
            case 6:
                return "Jul: ";
            case 7:
                return "Aug: ";
            case 8:
                return "Sep: ";
            case 9:
                return "Oct: ";
            case 10:
                return "Nov: ";
            case 11:
                return "Dec: ";
            default:
                return "Jan";
        }

    }
}
