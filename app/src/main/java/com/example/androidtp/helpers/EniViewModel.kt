package com.example.androidtp.helpers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.AppViewHelper.Companion.catchDialogHelper
import com.example.androidtp.api.ResponseAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class EniViewModel : ViewModel() {

    fun <T> genericApiCall(progressMessage : String, onExec: suspend () -> ResponseAPI<T>, onFinish: (apiResponse : ResponseAPI<T>) -> Unit){
        // Afficher la popup avec message traduit
        AppDialogHelpers.get().showDialog(progressMessage)

        // tâche async
        viewModelScope.launch {

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            try {
                // Callback qu'est ce que j'appel
                val apiResponse = onExec()

                // Fermer la popup de chargement
                AppDialogHelpers.get().closeDialog()

                onFinish(apiResponse)

            } catch (e: Exception) {
                catchDialogHelper("Erreur inconnue")
            }
        }
    }
}