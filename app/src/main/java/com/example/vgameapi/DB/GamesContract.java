package com.example.vgameapi.DB;

import android.provider.BaseColumns;

public class GamesContract {
    private GamesContract(){}
    public static class GamesEntry implements BaseColumns {
        public static final String TABLE_NAME ="games";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_DESC_TITLE = "description";
    }
}