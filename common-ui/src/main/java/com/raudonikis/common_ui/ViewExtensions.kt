package com.raudonikis.common_ui

import android.view.View

fun View.showIf(condition: () -> Boolean) {
    if (condition()) {
        show()
    } else {
        hide()
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.enableIf(condition: () -> Boolean) {
    if (condition()) {
        enable()
    } else {
        disable()
    }
}