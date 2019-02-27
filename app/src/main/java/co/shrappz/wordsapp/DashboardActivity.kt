package co.shrappz.wordsapp

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.UserDictionary
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import co.shrappz.wordsapp.adapter.RecyclerViewAdapter
import co.shrappz.wordsapp.constants.IntentConstants
import co.shrappz.wordsapp.db.NewWordTable
import co.shrappz.wordsapp.model.NewWord
import java.util.*

class DashboardActivity : AppCompatActivity() {

    private val newWordsList:MutableList<NewWord> = mutableListOf()
    var adapter:RecyclerViewAdapter? = null
    var mAddNewDialog:Dialog ?= null
    val ADD_WORD_REQ_CODE = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val rv :RecyclerView = findViewById(R.id.full_words_rv)

        loadData()
        adapter = RecyclerViewAdapter(this,newWordsList)
        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.adapter = adapter
    }

    private fun loadData(){
        newWordsList.addAll(NewWordTable().getAllWords(this));
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add_word){
            /*if(mAddNewDialog == null){
                mAddNewDialog = Dialog(this,0)
                mAddNewDialog!!.setContentView(R.layout.add_new_word)
                mAddNewDialog!!.setCancelable(true)
            }
            mAddNewDialog?.show()*/
            startActivityForResult(Intent(this,AddWordActivity::class.java),ADD_WORD_REQ_CODE)
            return true
        }
        else if(item?.itemId == R.id.sort_by_name){
            val sortedList = ArrayList<NewWord>(newWordsList)
            sortedList.sort()
            adapter?.updateList(sortedList,true)
            return true
        }
        return false
    }

    fun onClick(view: View){
        if(view.id == R.id.add_word_btn){
            mAddNewDialog?.dismiss()
            val wordEdt:EditText? =mAddNewDialog?.findViewById(R.id.word_edt)
            val meaningEdt:EditText? = mAddNewDialog?.findViewById(R.id.meaning_edt)
            val sourceEdt:EditText? = mAddNewDialog?.findViewById(R.id.source_edt)
            val word = wordEdt?.text.toString()
            val meaning = meaningEdt?.text.toString()
            val source  = sourceEdt?.text.toString()
            val newWord = NewWord(word,meaning,source,System.currentTimeMillis())
            if(newWordsList.contains(newWord)){
                Toast.makeText(this,"Word already exists",Toast.LENGTH_SHORT).show()
            }else{
                NewWordTable().insertWord(this,newWord)
                val tempList:ArrayList<NewWord> = ArrayList(newWordsList)
                tempList.add(0,newWord)
                adapter?.updateList(tempList,false)
            }
            wordEdt?.setText("")
            meaningEdt?.setText("")
            sourceEdt?.setText("")

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ADD_WORD_REQ_CODE){
            val newWord: NewWord? = data?.getParcelableExtra<NewWord>(IntentConstants.INTENT_FULLWORD)
            if(newWordsList.contains(newWord)){
                Toast.makeText(this,"Word already exists",Toast.LENGTH_SHORT).show()
            }else{
                if(newWord!=null) {
                    NewWordTable().insertWord(this, newWord)
                    val tempList: ArrayList<NewWord> = ArrayList(newWordsList)
                    tempList.add(0, newWord)
                    adapter?.updateList(tempList,false)
                }
            }
        }
    }
}
