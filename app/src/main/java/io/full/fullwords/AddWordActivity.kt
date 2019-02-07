package io.full.fullwords

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import io.full.fullwords.constants.IntentConstants
import io.full.fullwords.db.FullWordTable
import io.full.fullwords.model.FullWord

class AddWordActivity : AppCompatActivity() {

    var wordEdt: EditText? = null
    var meaningEdt: EditText? = null
    var sourceEdt: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        wordEdt = findViewById(R.id.word_edt)
        meaningEdt =  findViewById(R.id.meaning_edt)
        sourceEdt =  findViewById(R.id.source_edt)

    }



    fun onClick(view: View){
        if(view.id == R.id.add_word_btn){
            val word = wordEdt?.text.toString()
            val meaning = meaningEdt?.text.toString()
            val source  = sourceEdt?.text.toString()
            val fullWord = FullWord(word,meaning,source,System.currentTimeMillis())

            val intent = Intent()
            intent.putExtra(IntentConstants.INTENT_FULLWORD,fullWord)
            setResult(Activity.RESULT_OK,intent)
        }
    }


}
