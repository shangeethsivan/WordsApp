package co.shrappz.wordsapp.model

import android.os.Parcel
import android.os.Parcelable

data class NewWord(var word:String, var meaning:String, var source:String, var dateAdded:Long): Parcelable,Comparable<NewWord>{

    override fun compareTo(other: NewWord): Int {
        return word.compareTo(other.word)
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(word)
        dest.writeString(meaning)
        dest.writeString(source)
        dest.writeLong(dateAdded)
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun equals(other: Any?): Boolean {
        return word == (other as NewWord).word
    }

    companion object CREATOR : Parcelable.Creator<NewWord> {
        override fun createFromParcel(parcel: Parcel): NewWord {
            return NewWord(parcel)
        }

        override fun newArray(size: Int): Array<NewWord?> {
            return arrayOfNulls(size)
        }
    }
}