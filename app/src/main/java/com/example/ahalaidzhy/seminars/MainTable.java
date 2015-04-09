package com.example.ahalaidzhy.seminars;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by a.halaidzhy on 26.03.15.
 */
public class MainTable implements BaseColumns {
    private MainTable() {

    }

    public static final String TABLE_NAME = "Main";

    public static final Uri CONTENT_URI = Uri.parse("content://" + CommonConstantsHelper.AUTHORITY + "/" + TABLE_NAME);

    public static final String COLUMN_NAME_DATA = "data";
}
