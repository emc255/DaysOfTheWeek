package com.emc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        dateEnter();
    }

    public static void dateEnter() {
        System.out.println("Enter Date");
        Scanner userInput = new Scanner(System.in);
        boolean start = true;
        DatePattern datePattern = new DatePattern();

        while(start) {
            String tempDate = userInput.nextLine();
            if(datePattern.dateValidation(tempDate)) {
                DateString date = datePattern.createDateString(tempDate);
                if(date.getNumberInMonth() == 2 && !date.isLeapYear() && date.getDays() > 28) {
                    System.out.println(tempDate + " is not leap year theres only 28 days");
                    tryAgain();
                } else if (date.getYears() < 1700 || date.getYears() > 2200) {
                    System.out.println(date.getYears() + " is invalid can only calculate years from 1700-2199");
                    tryAgain();
                } else {
                    System.out.println(tempDate + " is " +date.getDayOfTheWeek());
                }

            } else {
                System.out.println("Invalid Date");
                tryAgain();

            }
            start = false;

        }
        userInput.close();
    }

    public static void tryAgain() {
        System.out.println("Try again y/n");
        Scanner yesOrNo = new Scanner(System.in);
        boolean start = true;
        while(start) {
            if(yesOrNo.hasNext("[ynYN]")) {
                String choice = yesOrNo.nextLine();
                if(choice.equals("y") || choice.equals("Y")) {
                    dateEnter();
                } else {
                    System.out.println("Quitting");

                }
            } else {
                System.out.println("Invalid Input");
                tryAgain();

            }
            start = false;

        }
        yesOrNo.close();
    }

}
