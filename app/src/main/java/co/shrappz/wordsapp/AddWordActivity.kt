package co.shrappz.wordsapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.shrappz.wordsapp.constants.IntentConstants
import co.shrappz.wordsapp.model.NewWord
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

    }



    fun onClick(view: View){
        if(view.id == add_word_btn_act.id){
            val word = word_edt_act.text.toString()
            val meaning = meaning_edt_act.text.toString()
            val source  = source_edt_act.text.toString()
            val fullWord = NewWord(word,meaning,source,System.currentTimeMillis())

            val intent = Intent()
            intent.putExtra(IntentConstants.INTENT_FULLWORD,fullWord)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }


}
