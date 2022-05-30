package ru.job4j.condition;

public class WeeklySalary {
    public static int calculate(int[] hours) {
        int rsl = 0;
        int standardPay = 10;
        int upStandardPay = 15;
        int dayOffStandardPay = standardPay * 2;
        int dayOffUpStandardPay = upStandardPay * 2;
        int standardHours = 8;

        for (int i = 0; i < hours.length; i++) {
            if (i <= 4 && hours[i] > 0 && hours[i] <= standardHours) {
                rsl += hours[i] * standardPay;
            } else if (i <= 4 && hours[i] > standardHours) {
                rsl += (standardHours * standardPay) + (hours[i] - standardHours) * upStandardPay;
            } else if (i > 4 && hours[i] <= standardHours) {
                rsl += (hours[i] * dayOffStandardPay);
            } else if (i > 4 && hours[i] > standardHours) {
                rsl += (standardHours * dayOffStandardPay) + (hours[i] - standardHours) * dayOffUpStandardPay;
            }
        }
        return rsl;
    }
}
