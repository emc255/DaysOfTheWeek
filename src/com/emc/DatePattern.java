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
            "|october|oct" +
            "|december|dec) " +
            "([0-2]{1}[0-9]{1}|[0-9]{1}|[3]{1}[0-1]{1}), ([0-9]{4})$)";

    private final String MONTHSWITH30DAYSPATTERN = "^((april|apr" +
            "|june|jun" +
            "|september|sep" +
            "|november|nov) " +
            "([0-2]{1}[0-9]{1}|[0-9]{1}|[3]{1}[0-1]{1}), ([0-9]{4})$)";

    private final String MONTHWITH29DAYSPATTERN = "^((february|feb) " +
            "([0-2]{1}[0-9]{1}|[0-9]{1}), ([0-9]{4})$)";

    public boolean dateValidation(String userInputDate) {
        List<Pattern> rxs = new ArrayList<>(
                Arrays.asList(Pattern.compile(MONTHSWITH31DAYSPATTERN, Pattern.CASE_INSENSITIVE),
                        Pattern.compile(MONTHSWITH30DAYSPATTERN, Pattern.CASE_INSENSITIVE),
                        Pattern.compile(MONTHWITH29DAYSPATTERN, Pattern.CASE_INSENSITIVE)
                ));

        for (Pattern pattern: rxs) {
            if (pattern.matcher(userInputDate).matches()) {
                return true;
            }
        }

        return false;
    }

  public DateString createDateString(String userInputDate ) {
        Pattern pattern = Pattern.compile(PATTERN1, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userInputDate);
        DateString date = null;
        while (matcher.find()) {
            date = new DateString(matcher.group(2).toLowerCase(),
                    Integer.parseInt(matcher.group(3)),
                    Integer.parseInt(matcher.group(4))
                    );
        }
        return date;
  }

}
