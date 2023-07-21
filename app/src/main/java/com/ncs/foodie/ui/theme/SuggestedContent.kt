package com.ncs.foodie.ui.theme

import androidx.annotation.DrawableRes

data class SuggestedContent(

    val Title:String,
    val Price:Int,
    @DrawableRes val Image:Int,
) {
}