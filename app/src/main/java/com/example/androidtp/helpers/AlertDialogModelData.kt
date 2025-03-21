package com.example.androidtp.helpers

data class AlertDialogModelData(var isShow : Boolean = false, var message : String = "", var onClose : () -> Unit = {}) {
}