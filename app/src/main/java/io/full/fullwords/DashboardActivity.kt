package io.full.fullwords

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import io.full.fullwords.adapter.RecyclerViewAdapter
import io.full.fullwords.model.FullWord
import kotlinx.android.synthetic.main.add_new_word.*

class DashboardActivity : AppCompatActivity() {

    private val fullWordsList:MutableList<FullWord> = mutableListOf()
    var adapter:RecyclerViewAdapter? = null
    var mAddNewDialog:Dialog ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val rv :RecyclerView = findViewById(R.id.full_words_rv)
        loadData()
        adapter = RecyclerViewAdapter(this,fullWordsList)
        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.adapter = adapter
    }

    private fun loadData(){
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
        fullWordsList.add(FullWord("Context","test","test",12345L))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add_word){
            if(mAddNewDialog == null){
                mAddNewDialog = Dialog(this,0)
                mAddNewDialog!!.setContentView(R.layout.add_new_word)
                mAddNewDialog!!.setCancelable(true)
            }
            mAddNewDialog?.show()
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
            val fullWord = FullWord(word,meaning,source,System.currentTimeMillis())
            if(fullWordsList.contains(fullWord)){
                Toast.makeText(this,"Word already exists",Toast.LENGTH_SHORT).show()
            }else{
                fullWordsList.add(fullWord)
                adapter?.notifyDataSetChanged()
            }
            wordEdt?.setText("")
            meaningEdt?.setText("")
            sourceEdt?.setText("")
        }
    }
}
