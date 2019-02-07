package co.shrappz.wordsapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(pContext:Context) : SQLiteOpenHelper(pContext,"NewWordsDb",null,1){

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(pSqlDb: SQLiteDatabase?) {
        NewWordTable.createTable(pSqlDb!!)
    }

}