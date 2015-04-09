package com.example.ahalaidzhy.seminars;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.HashMap;

/**
 * Created by a.halaidzhy on 26.03.15.
 */
public class SimpleProvider extends ContentProvider {
    private DatabaseHelper mOpenHelper;
    private final HashMap<String, String> mNotesProjectionMap;

    SimpleProvider() {
        mNotesProjectionMap = new HashMap<String, String>();
        mNotesProjectionMap.put(MainTable._ID, MainTable._ID);
        mNotesProjectionMap.put(MainTable.COLUMN_NAME_DATA, MainTable.COLUMN_NAME_DATA);
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        if (uri == null || !uri.equals(MainTable.CONTENT_URI)) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }

        ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        }
        else {
            values = new ContentValues();
        }

        if (!values.containsKey(MainTable.COLUMN_NAME_DATA)) {
            values.put(MainTable.COLUMN_NAME_DATA, "");
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        long rowId = db.insert(MainTable.TABLE_NAME, null, values);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
