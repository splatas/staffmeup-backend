package com.postres.staffing_follower.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Field {
    public static Boolean equal(final String field, final String otherField){
        String myField = getValueNormalized(field);
        String myOtherField = getValueNormalized(otherField);

        if(myField == null && myOtherField == null){
            return true;
        }

        if(myField == null || myOtherField == null){
            return false;
        }

        if(myField.equalsIgnoreCase(myOtherField)){
            return true;
        }

        return false;
    }


    public static boolean equal(Integer field, Integer otherField) {
        if(field == null && otherField == null){
            return true;
        }
        if(field == null && otherField != null){
            return false;
        }

        if(field != null && otherField == null){
            return false;
        }


        if(field.intValue() == otherField.intValue()){
            return true;
        }

        return false;
    }

    public static boolean equal(Date field, Date otherField) {
        if(field == null && otherField == null){
            return true;
        }
        if(field == null && otherField != null){
            return false;
        }

        if(field != null && otherField == null){
            return false;
        }
        if(field.compareTo(otherField) == 0){
            return true;
        }
        return false;

    }

    public static String getValueNormalized(final String value, final String valueDefault) {
        String valueOK  = null;
        if(value != null && !value.trim().equals("")){
            valueOK = value.trim().toLowerCase();
        }

        return valueOK == null? valueDefault:valueOK;
    }

    public static String getValueNormalized(final String value) {
        String valueOK  = null;
        if(value != null && !value.trim().equals("")){
            valueOK = value.trim().toLowerCase();
        }
        return valueOK;
    }

    public static String getValue(final String value) {
        String valueOK  = null;
        if(value != null && !value.trim().equals("")){
            valueOK = value.trim();
        }
        return valueOK;
    }



    public static Date getDate(String stringDate) {
        if(stringDate == null || stringDate.trim().equals("")){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        LocalDate dateTime = LocalDate.parse(stringDate, formatter);
        Date date = Date.from(dateTime.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }


}
