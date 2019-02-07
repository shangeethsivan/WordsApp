package co.shrappz.wordsapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import co.shrappz.wordsapp.model.NewWord

class NewWordTable {

    companion object {

        private const val TABLE_NAME = "NewWordTable"
        private const val C_WORD: String = "c_word"
        private const val C_MEANING: String = "c_meaning"
        private const val C_SOURCE: String = "c_source"
        private const val C_DATE_ADDED: String = "c_dateAdded"
        private const val _ID: String = "_ID"

        private const val CREATE_TABLE_QUERY = "CREATE TABLE $TABLE_NAME($_ID INTEGER PRIMARY KEY AUTOINCREMENT,$C_WORD TEXT,$C_MEANING TEXT,$C_SOURCE TEXT,$C_DATE_ADDED INTEGER)"

        fun createTable(pSqlDb: SQLiteDatabase) {
            pSqlDb.execSQL(NewWordTable.CREATE_TABLE_QUERY)
        }

    }



    fun insertWord(pContext: Context, newWord: NewWord):Long {

        val dbHelper = DbHelper(pContext)
        val sqliteDataBase = dbHelper.writableDatabase

        var insertedId :Long = -1

        sqliteDataBase.use {
            val contentValues = ContentValues()
            contentValues.put(C_WORD, newWord.word)
            contentValues.put(C_MEANING, newWord.meaning)
            contentValues.put(C_SOURCE, newWord.source)
            contentValues.put(C_DATE_ADDED, newWord.dateAdded)
            insertedId = sqliteDataBase.insert(TABLE_NAME, null, contentValues)
        }
        return insertedId
    }

    fun getAllWords(pContext: Context): List<NewWord> {

        val wordsList: MutableList<NewWord> = mutableListOf()

        val dbHelper = DbHelper(pContext)
        val sqliteDataBase = dbHelper.readableDatabase

        sqliteDataBase.use {
            val cursor = sqliteDataBase.query(TABLE_NAME, null, null, null, null, null, "$C_DATE_ADDED DESC")
            if(cursor.moveToFirst()){
                do {
                    val fullWord = NewWord(cursor.getString(cursor.getColumnIndex(C_WORD)), cursor.getString(cursor.getColumnIndex(C_WORD)), cursor.getString(cursor.getColumnIndex(C_WORD)), cursor.getLong(cursor.getColumnIndex(C_DATE_ADDED)));
                    wordsList.add(fullWord)
                }while (cursor.moveToNext());
            }
        }

        return wordsList
    }
}