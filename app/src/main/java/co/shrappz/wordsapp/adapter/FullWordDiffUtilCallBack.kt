package co.shrappz.wordsapp.adapter

import co.shrappz.wordsapp.model.NewWord

class FullWordDiffUtilCallBack(pFirstList: List<NewWord>, pSecondList: List<NewWord>) : CustomDiffUtilCallBack<NewWord>(pFirstList, pSecondList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mFirstList[oldItemPosition] == mSecondList[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return mFirstList.size
    }

    override fun getNewListSize(): Int {
        return mSecondList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mFirstList[oldItemPosition].word == mSecondList[newItemPosition].word
    }

}