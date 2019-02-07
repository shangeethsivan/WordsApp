package co.shrappz.wordsapp.adapter

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.shrappz.wordsapp.R
import co.shrappz.wordsapp.model.NewWord

class RecyclerViewAdapter(pContext:Context,pItems:MutableList<NewWord>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    val mContext:Context = pContext
    val mitems:MutableList<NewWord> = pItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater :LayoutInflater= mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return ViewHolder(layoutInflater.inflate(R.layout.item_words,parent,false))
    }

    override fun getItemCount(): Int {
      return mitems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fullword: NewWord  = mitems.get(position)
        holder.wordTv.text = fullword.word
        holder.meaningTv.text = fullword.meaning
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val meaningTv: TextView = itemView.findViewById(R.id.meaning_tv)
        val wordTv: TextView = itemView.findViewById(R.id.word_tv)
    }

    fun updateList(pNewList:List<NewWord>){
        val diffResult:DiffUtil.DiffResult = DiffUtil.calculateDiff(FullWordDiffUtilCallBack(mitems,pNewList))
        mitems.clear()
        mitems.addAll(pNewList)
        diffResult.dispatchUpdatesTo(this)
    }
}