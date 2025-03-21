package com.example.androidtp.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidtp.AppViewHelper
import com.example.androidtp.R
import com.example.androidtp.ui.theme.EniButton
import com.example.androidtp.ui.theme.EniPage
import com.example.androidtp.ui.theme.EniTextField
import com.example.androidtp.ui.theme.TitlePage
import com.example.androidtp.ui.theme.WrapPadding


@Composable
fun SignUpPage(navController: NavHostController) {
    // Ecouter en temps réel le changement de signUpRequestData*
    val viewModel = AuthViewModel.get();

    val signUpRequestDataState by viewModel.signUpRequestData.collectAsState()

    // Récupérer le context de l'app
    val context = LocalContext.current

    EniPage {
        Column(modifier = Modifier.padding(40.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TitlePage(text = stringResource(R.string.app_title_signup), verticalPadding = 30.dp)
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.pseudo,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(pseudo = value)},
                    hintText = stringResource(R.string.app_field_pseudo_hint))
            }
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.email,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(email = value)},
                    hintText = stringResource(R.string.app_field_email_hint))
            }
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.password,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(password = value)},
                    hintText = stringResource(R.string.app_field_password_hint))
            }
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.passwordConfirm,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(passwordConfirm = value)},
                    hintText = stringResource(R.string.app_field_password_confirm_hint))
            }
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.city,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(city = value)},
                    hintText = stringResource(R.string.app_field_city_hint))
            }
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.cityCode,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(cityCode = value)},
                    hintText = stringResource(R.string.app_field_city_code_hint))
            }
            WrapPadding {
                EniTextField(
                    value = signUpRequestDataState.phone,
                    onValueChange =  { value -> viewModel.signUpRequestData.value = viewModel.signUpRequestData.value.copy(phone = value)},
                    hintText = stringResource(R.string.app_field_phone_hint))
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_submit),
                    onClick = {
                        AuthViewModel.get().callsignUpRequest(onSignUpSuccess = {
                            navController.navigate("login")
                        })
                    })
            }
        }
    }
}

@Composable
@Preview
fun SignUpPreview(){

    val navController = rememberNavController()

    SignUpPage(navController)
}