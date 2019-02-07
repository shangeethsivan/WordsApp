package io.full.fullwords.adapter

import io.full.fullwords.model.FullWord

class FullWordDiffUtilCallBack(pFirstList: List<FullWord>, pSecondList: List<FullWord>) : CustomDiffUtilCallBack<FullWord>(pFirstList, pSecondList) {

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