package com.example.vgameapi.DB;

import android.provider.BaseColumns;

public class GamesContract {
    private GamesContract(){}
    public static class GamesEntry implements BaseColumns {
        public static final String TABLE_NAME ="contacts";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
    }
}