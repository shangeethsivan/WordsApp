package io.full.fullwords.adapter

import android.support.v7.util.DiffUtil
import io.full.fullwords.model.FullWord

abstract class CustomDiffUtilCallBack<E> : DiffUtil.Callback {

    var mFirstList :List<E>
    var mSecondList :List<E>

    constructor(pFirstList: List<E>, pSecondList: List<E>) {

        this.mFirstList = pFirstList
        this.mSecondList = pSecondList

    }

}