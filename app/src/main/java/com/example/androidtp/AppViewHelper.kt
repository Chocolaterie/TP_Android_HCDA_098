package com.example.androidtp

import android.content.Context
import android.content.Intent
import com.example.androidtp.helpers.AppAlertDialogHelpers
import com.example.androidtp.helpers.AppDialogHelpers
import kotlin.reflect.KClass

class AppViewHelper {

    companion object {

        fun openActivity(context: Context, kClass: KClass<*>){
            // Specifier quelle action : PS quel activity à ouvrir
            val intent = Intent(context, kClass.java)
            // Ouvrir l'ativity
            context.startActivity(intent)
        }

        fun catchDialogHelper(errorMessage : String){
            // Fermer la popup de chargement
            AppDialogHelpers.get().closeDialog()

            AppAlertDialogHelpers.get().show(errorMessage)
        }
    }

}