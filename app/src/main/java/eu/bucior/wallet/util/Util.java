package eu.bucior.wallet.util;

import java.util.StringJoiner;

public class Util {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "wallet";
    public static final String TABLE_NAME = "operations";

    public static final String KEY_ID = "id";
    public static final String KEY_DATE_ADDED = "date_added";
    public static final String KEY_DATE_OPERATION = "date_operation";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_POSTING_KEY = "posting_key";


    public static String formatDate(int y, int m, int d) {
        String year  = String.format("%04d", y);
        String month  = String.format("%02d", m);
        String day  = String.format("%02d", d);

        StringJoiner joiner = new StringJoiner("-");
        joiner.add(year).add(month).add(day);
        String date = joiner.toString();

        return date;
    }
}
