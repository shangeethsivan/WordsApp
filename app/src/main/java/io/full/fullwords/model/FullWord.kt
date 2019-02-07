package io.full.fullwords.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class FullWord(var word:String, var meaning:String, var source:String,var dateAdded:Long): Parcelable,Comparable<FullWord>{

    override fun compareTo(other: FullWord): Int {
        return word.compareTo(other.word)
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        dest.writeString(word)
        dest.writeString(meaning)
        dest.writeString(source)
        dest.writeLong(dateAdded)
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun equals(other: Any?): Boolean {
        return word == (other as FullWord).word
    }

    companion object CREATOR : Parcelable.Creator<FullWord> {
        override fun createFromParcel(parcel: Parcel): FullWord {
            return FullWord(parcel)
        }

        override fun newArray(size: Int): Array<FullWord?> {
            return arrayOfNulls(size)
        }
    }
}