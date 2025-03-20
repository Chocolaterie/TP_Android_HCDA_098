package com.example.androidtp.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    // Servira à lier les donneés dans les champs
    // Et aussi à envoyer en JSON dans l'API
    var loginRequestData = MutableStateFlow(LoginRequestData())

    fun callLoginRequest(onLoginSuccess: () -> Unit = {}) {
        // Afficher la popup avec message traduit
        AppDialogHelpers.get().showDialog("Tentative de connexion en cours")

        // tâche async
        viewModelScope.launch {

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            // Appel api /login avec dans le body mon loginRequestData (donc email,password)
            val apiResponse = AuthService.AuthApi.authService.login(loginRequestData.value)

            // Fermer la popup de chargement
            AppDialogHelpers.get().closeDialog()

            // Tester si OK : 200
            if (apiResponse.code.equals("200")){
                // Stocker le token
                AuthService.token = apiResponse.data!!

                // Afficher le message popup succés
                // TODO : Pour le moment la popup = message console
                println(apiResponse.message)

                // TODO : Pour le moment comme pas encore de popup trouver un moyen d'appeler le callback
                onLoginSuccess()
            }
            else {
                // Afficher le message popup erreur
                // TODO : Pour le moment la popup = message console
                println(apiResponse.message)
            }
        }
    }
}