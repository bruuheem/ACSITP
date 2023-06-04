package com.example.acsitp;

import android.provider.BaseColumns;

import java.sql.Array;

public class MaladieContract {

    private MaladieContract() {
    }

    public static class MaladieEntry implements BaseColumns {
        public static final String TABLE_NAME = "maladies";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String COLUMN_SYP = "syptome";

    }
}
