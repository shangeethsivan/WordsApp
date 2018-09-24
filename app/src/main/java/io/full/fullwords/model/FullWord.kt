package io.full.fullwords.model

data class FullWord(var word:String, var meaning:String, var source:String,var dateAdded:Long){
    override fun equals(other: Any?): Boolean {
        return word == (other as FullWord).word
    }
}