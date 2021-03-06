package com.etu3892.functional;


import java.sql.Timestamp;


public final class SportsDateTime extends Timestamp{
    public SportsDateTime(long time) {
        super(time);
    }

    public SportsDateTime (Timestamp timestamp){
        super(timestamp.getTime());
    }
    @Override
    public String toString () {

        int year = super.getYear() + 1900;
        int month = super.getMonth() + 1;
        int day = super.getDate();
        int hour = super.getHours();
        int minute = super.getMinutes();
        int second = super.getSeconds();
        String yearString;
        String monthString;
        String dayString;
        String hourString;
        String minuteString;
        String secondString;
        String nanosString;
        String zeros = "000000000";
        String yearZeros = "0000";
        StringBuffer timestampBuf;

        if (year < 1000) {
            // Add leading zeros
            yearString = "" + year;
            yearString = yearZeros.substring(0, (4-yearString.length())) +
                    yearString;
        } else {
            yearString = "" + year;
        }
        if (month < 10) {
            monthString = "0" + month;
        } else {
            monthString = Integer.toString(month);
        }
        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = Integer.toString(day);
        }
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = Integer.toString(hour);
        }
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = Integer.toString(minute);
        }
        if (second < 10) {
            secondString = "0" + second;
        } else {
            secondString = Integer.toString(second);
        }
        if (getNanos() == 0) {
            nanosString = "0";
        } else {
            nanosString = Integer.toString(getNanos());

            // Add leading zeros
            nanosString = zeros.substring(0, (9-nanosString.length())) +
                    nanosString;

            // Truncate trailing zeros
            char[] nanosChar = new char[nanosString.length()];
            nanosString.getChars(0, nanosString.length(), nanosChar, 0);
            int truncIndex = 8;
            while (nanosChar[truncIndex] == '0') {
                truncIndex--;
            }

            nanosString = new String(nanosChar, 0, truncIndex + 1);
        }

        // do a string buffer here instead.
        timestampBuf = new StringBuffer(20+nanosString.length());
        timestampBuf.append(dayString);
        timestampBuf.append(".");
        timestampBuf.append(monthString);
        timestampBuf.append(".");
        timestampBuf.append(yearString);
        timestampBuf.append(" | ");
        timestampBuf.append(hourString);
        timestampBuf.append(":");
        timestampBuf.append(minuteString);

        return (timestampBuf.toString());
    }


}
