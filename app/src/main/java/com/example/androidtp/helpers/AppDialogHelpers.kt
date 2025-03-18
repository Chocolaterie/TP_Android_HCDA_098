package com.example.androidtp.helpers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.flow.MutableStateFlow

class AppDialogHelpers {

    companion object {
        val instance : AppDialogHelpers by lazy { AppDialogHelpers() }

        fun get() : AppDialogHelpers {
            return instance;
        }
    }

    // Sert à savoir en temps réel si il faut afficher ou pas la dialog
    var dialogModelData = MutableStateFlow(DialogModelData());

    /**
     * Afficher la popup
     */
    fun showDialog(message: String){
        // Forcer le rafraichissement de l'etat
        dialogModelData.value = dialogModelData.value.copy(isShow = true, message = message);
    }

    /**
     * Fermer la popup
     */
    fun closeDialog() {
        // Forcer le rafraichissement de l'etat
        dialogModelData.value = dialogModelData.value.copy(isShow = false);
    }
}

@Composable
fun ProgressDialog(){
    // Je vais ecouter quand la dialog est true ou false
    // Donc quand je dois afficher ou pas
    val dialogModelDataState by AppDialogHelpers.get().dialogModelData.collectAsState();

    if (dialogModelDataState.isShow) {
        Dialog(onDismissRequest = {}){
            Box(modifier = Modifier.background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(30.dp)
            )
                .padding(20.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Text(text = dialogModelDataState.message)
                }
            }
        }
    }
}