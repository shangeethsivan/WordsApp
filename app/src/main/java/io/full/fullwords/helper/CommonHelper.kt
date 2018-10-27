package io.full.fullwords.helper

import android.text.TextUtils
import java.util.regex.Pattern

class CommonHelper{

fun validateEmail(pEmailId:String) : Boolean{
    if(TextUtils.isEmpty(pEmailId)){
        return false
    }
    val expression = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(pEmailId)
    return matcher.find()
}
}