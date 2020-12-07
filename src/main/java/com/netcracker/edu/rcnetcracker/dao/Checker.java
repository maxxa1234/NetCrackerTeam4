package com.netcracker.edu.rcnetcracker.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static void checkNumParameter(String numParameter){
        Pattern pattern = Pattern.compile("^([=><])\\s?\\d+");
        Matcher matcher = pattern.matcher(numParameter);
        if (!matcher.find()){
            throw new IllegalArgumentException("Incorrect number format.");
        }
    }

    public static void checkDateParameter(String dateParameter){
        Pattern pattern = Pattern.compile("((3(1|0))|[1-2][0-9])[/.\\-]((0[1-9])|(1[0-2]))[/.\\-](20[0-9]{2})");
        Matcher matcher = pattern.matcher(dateParameter);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect date format.");
        }
    }

    public static void checkBooleanParameter(String booleanParameter){
        Pattern pattern = Pattern.compile("((true|false)|(TRUE|FALSE))");
        Matcher matcher = pattern.matcher(booleanParameter);
        if (!matcher.find()){
            throw new IllegalArgumentException("Incorrect boolean format.");
        }
    }

}
