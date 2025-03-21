package com.example.androidtp.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.helpers.AppAlertDialogHelpers
import com.example.androidtp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    // Servira à lier les donneés dans les champs
    // Et aussi à envoyer en JSON dans l'API
    var loginRequestData = MutableStateFlow(LoginRequestData())

    // Les informations d'inscription
    var signUpRequestData = MutableStateFlow(SignUpRequestData())

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
                AppAlertDialogHelpers.get().show(apiResponse.message, onClose = {
                    onLoginSuccess()
                })
            }
            else {
                // Afficher le message popup erreur
                AppAlertDialogHelpers.get().show(apiResponse.message)
            }
        }
    }

    fun callResetPasswordRequest() {
        // Afficher la popup avec message traduit
        AppDialogHelpers.get().showDialog("Demande réinitialisation mot de passe")

        // tâche async
        viewModelScope.launch {

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            // Forcer a vider tout les champs sauf email
            loginRequestData.value.password = null;

            // Appel api /login avec dans le body mon loginRequestData (donc email)
            val apiResponse = AuthService.AuthApi.authService.resetPassword(loginRequestData.value)

            // Fermer la popup de chargement
            AppDialogHelpers.get().closeDialog()

            // Afficher le message popup succés
            AppAlertDialogHelpers.get().show(apiResponse.message)

            // Tester si OK : 200
            if (apiResponse.code.equals("200")){
                // Afficher le new password dans la console
                println(apiResponse.data!!)
            }
        }
    }

    fun callsignUpRequest(onSignUpSuccess: () -> Unit = {}) {
        // Afficher la popup avec message traduit
        AppDialogHelpers.get().showDialog("Inscription en cours")

        // tâche async
        viewModelScope.launch {

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            // Appel api /login avec dans le body mon loginRequestData (donc email)
            val apiResponse = AuthService.AuthApi.authService.signUp(signUpRequestData.value)

            // Fermer la popup de chargement
            AppDialogHelpers.get().closeDialog()

            // Afficher le message popup succés
            AppAlertDialogHelpers.get().show(apiResponse.message)

            // Tester si OK : 200
            if (apiResponse.code.equals("200")){
                // Callback
                onSignUpSuccess()
            }
        }
    }
}