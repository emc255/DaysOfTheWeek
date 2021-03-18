package com.emc;

public class DateString {
    private final String month;
    private final int numberInMonth;
    private final int days;
    private final int years;
    private final boolean isLeapYear;
    private final String dayOfTheWeek;


    public DateString(String month, int days, int years) {
        this.month = month;
        this.days = days;
        this.years = years;
        this.isLeapYear = isLeapYear(years);
        this.numberInMonth = numberInMonth(month);
        this.dayOfTheWeek = calculateDaysOfTheWeek(month, days, years);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int numberInMonth(String month) {
        switch (month) {
            case "january":
            case "jan":
                return 1;
            case "february":
            case "feb":
                return 2;
            case "march":
            case "mar":
                return 3;
            case "april":
            case "apr":
                return 4;
            case "may":
                return 5;
            case "june":
            case "jun":
                return 6;
            case "july":
            case "jul":
                return 7;
            case "august":
            case "aug":
                return 8;
            case "september":
            case "sep":
                return 9;
            case "october":
            case "oct":
                return 10;
            case "november":
            case "nov":
                return 11;
            default:
                return 12;
        }
    }

    private int centuriesTable(int year) {
        if (year >= 1700 && year <= 1799) {
            return 4;
        } else if (year >= 1800 && year <= 1899) {
            return 2;
        } else if (year >= 1900 && year <= 1999) {
            return 0;
        } else if (year >= 2000 && year <= 2099) {
            return 6;
        } else if (year >= 2100 && year <= 2199) {
            return 4;
        } else {
            return -1;
        }
    }

    private int monthsTable(String month) {
        switch (month) {
            case "january":
            case "jan":
                if (this.isLeapYear) {
                    return 6;
                }
                return 0;

            case "february":
            case "feb":
                if (this.isLeapYear) {
                    return 2;
                }
                return 3;

            case "march":
            case "mar":
            case "november":
            case "nov":
                return 3;

            case "april":
            case "apr":
            case "july":
            case "jul":
                return 6;

            case "may":
                return 1;

            case "june":
            case "jun":
                return 4;

            case "august":
            case "aug":
                return 2;

            case "september":
            case "sep":
            case "december":
            case "dec":
                return 5;

            case "october":
            case "oct":
                return 0;

            default:
                return -1;
        }
    }

    private String dayTable(int value) {
        switch (value) {
            case 0:
                return "sunday";
            case 1:
                return "monday";
            case 2:
                return "tuesday";
            case 3:
                return "wednesday";
            case 4:
                return "thursday";
            case 5:
                return "friday";
            default:
                return "saturday";
        }
    }

    private String calculateDaysOfTheWeek (String month, int days, int years) {
        int c = centuriesTable(years);
        int y = years % 100;
        int yy = (years % 100) / 4;
        int m = monthsTable(month);
        int result = (c + yy + y + m + days) % 7;
        return dayTable(result);
    }

    public String getMonth() {
        return month;
    }

    public int getNumberInMonth() {
        return numberInMonth;
    }

    public int getDays() {
        return days;
    }

    public int getYears() {
        return years;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
