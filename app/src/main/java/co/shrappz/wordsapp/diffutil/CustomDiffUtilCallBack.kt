package co.shrappz.wordsapp.diffutil

import android.support.v7.util.DiffUtil

abstract class CustomDiffUtilCallBack<E> : DiffUtil.Callback {

    var mFirstList :List<E>
    var mSecondList :List<E>

    constructor(pFirstList: List<E>, pSecondList: List<E>) {

        this.mFirstList = pFirstList
        this.mSecondList = pSecondList

    }

}