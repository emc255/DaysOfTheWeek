package com.emc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatePattern {

    private final String PATTERN1 = "^((january|jan" +
            "|february|feb" +
            "|march|mar" +
            "|april|apr" +
            "|may" +
            "|june|jun" +
            "|july|jul" +
            "|august|aug" +
            "|september|sep" +
            "|october|oct" +
            "|november|nov" +
            "|december|dec) " +
            "([0-3]{1}[0-9]{1}|[0-9]{1}), ([0-9]{4})$)";

    private final String MONTHSWITH31DAYSPATTERN = "^((january|jan" +
            "|march|mar" +
            "|may" +
            "|july|jul" +
            "|august|aug" +
            "|oct1ober|oct" +
            "|december|dec) " +
            "([0-2]{1}[0-9]{1}|[0-9]{1}|[3]{1}[0-1]{1}), ([0-9]{4})$)";

    private final String MONTHSWITH31DAYSPATTERN2 = "^([13578]|[0][13578]|[1][02])(/|-)" +
            "([0-2][0-9]|[0-9]{1})(/|-)([0-9]{4})$";

    private final String MONTHSWITH30DAYSPATTERN = "^((april|apr" +
            "|june|jun" +
            "|september|sep" +
            "|november|nov) " +
            "([0-2]{1}[0-9]{1}|[0-9]{1}|[3]{1}[0-1]{1}), ([0-9]{4})$)";

    private final String MONTHSWITH30DAYSPATTERN2 = "^([469]|[0][469]|[1][1])(/|-)" +
            "([0-2][0-9]|[0-9]{1})(/|-)([0-9]{4})$";

    private final String MONTHWITH29DAYSPATTERN = "^((february|feb) " +
            "([0-2]{1}[0-9]{1}|[0-9]{1}), ([0-9]{4})$)";


    private final String MONTHWITH29DAYSPATTERN2 = "^([2]|[0][2])(/|-)" +
            "([0-2][0-9]|[0-9]{1})(/|-)([0-9]{4})$";

    public boolean dateValidation(String userInputDate) {
        List<Pattern> datePattern = new ArrayList<>(
                Arrays.asList(Pattern.compile(MONTHSWITH31DAYSPATTERN, Pattern.CASE_INSENSITIVE),
                        Pattern.compile(MONTHSWITH30DAYSPATTERN, Pattern.CASE_INSENSITIVE),
                        Pattern.compile(MONTHWITH29DAYSPATTERN, Pattern.CASE_INSENSITIVE),
                        Pattern.compile(MONTHSWITH31DAYSPATTERN2),
                        Pattern.compile(MONTHSWITH30DAYSPATTERN2),
                        Pattern.compile(MONTHWITH29DAYSPATTERN2)
                ));

        for (Pattern pattern : datePattern) {
            if (pattern.matcher(userInputDate).matches()) {
                return true;
            }
        }

        return false;
    }

    public DateString createDateString(String userInputDate) {
        List<String> tempDate = Arrays.asList(userInputDate.split("[ ,-/]+"));

        Pattern pattern = Pattern.compile("(\\d|0\\d)");
        Matcher matcher = pattern.matcher(tempDate.get(0));

        if (!matcher.matches()) {
            return new DateString(
                    tempDate.get(0).toLowerCase(),
                    Integer.parseInt(tempDate.get(1)),
                    Integer.parseInt(tempDate.get(2))
            );
        } else {
            return new DateString(
                    Integer.parseInt(tempDate.get(0)),
                    Integer.parseInt(tempDate.get(1)),
                    Integer.parseInt(tempDate.get(2))
            );
        }
    }

}
