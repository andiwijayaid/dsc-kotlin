package dsc.workshop.androidloveskotlin.utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import dsc.workshop.androidloveskotlin.model.History
import kotlin.collections.ArrayList

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "db_basket_history"
        private val HISTORY_TABLE = "table_history"
        private val COLUMN_ID = "_id"
        private val COLUMN_POINT_A = "point_a"
        private val COLUMN_POINT_B = "point_b"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(" CREATE TABLE " + HISTORY_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_POINT_A + " INTEGER NOT NULL, " +
                COLUMN_POINT_B + " INTEGER NOT NULL);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $HISTORY_TABLE")
        this.onCreate(db)
    }

    fun saveHistory(history: History) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_POINT_A, history.poinA)
        values.put(COLUMN_POINT_B, history.poinB)

        db.insert(HISTORY_TABLE, null, values)
        db.close()
    }

    fun historyList(): ArrayList<History> {
        val query = "SELECT * FROM $HISTORY_TABLE"

        val historyList = ArrayList<History>()
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val history = History(0, 0)
                history.poinA = cursor.getLong(cursor.getColumnIndex(COLUMN_POINT_A)).toInt()
                history.poinB = cursor.getLong(cursor.getColumnIndex(COLUMN_POINT_B)).toInt()
                historyList.add(history)
            } while (cursor.moveToNext())
        }

        return historyList
    }
}