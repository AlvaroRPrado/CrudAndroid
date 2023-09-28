package com.prado.crudroom.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.prado.crudroom.R

private val slideLeftOptions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setEnterAnim(R.anim.slide_out_left)
    .setEnterAnim(R.anim.slide_in_left)
    .setEnterAnim(R.anim.slide_out_right)
    .build()

fun NavController.navigateWithAnimations(
    destinationInd: Int,
    animation: NavOptions = slideLeftOptions
){
    this.navigate(destinationInd, null, animation)
}

fun NavController.navigateWithAnimations(
    directions: NavDirections,
    animation: NavOptions = slideLeftOptions
) {
    this.navigate(directions, animation)
}