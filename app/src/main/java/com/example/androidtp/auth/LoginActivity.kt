package com.example.androidtp.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidtp.AppViewHelper
import com.example.androidtp.R
import com.example.androidtp.article.ArticleActivity
import com.example.androidtp.ui.theme.EniButton
import com.example.androidtp.ui.theme.EniPage
import com.example.androidtp.ui.theme.EniTextField
import com.example.androidtp.ui.theme.SecondaryTextInfo
import com.example.androidtp.ui.theme.TitlePage
import com.example.androidtp.ui.theme.WrapPadding

@Composable
fun LoginPage(navController: NavHostController) {
    val viewModel = AuthViewModel.get();

    // Ecouter en temps réel le changement de loginRequestData
    val loginRequestDataState by viewModel.loginRequestData.collectAsState()

    // Récupérer le context de l'app
    val context = LocalContext.current

    EniPage {
        Column(
            modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                modifier = Modifier.size(96.dp),
                contentDescription = null, tint = Color(0xDDFFFFFF)
            )
            TitlePage(text = stringResource(R.string.app_title_login), verticalPadding = 30.dp)
            SecondaryTextInfo(stringResource(R.string.app_msg_info_please_aware_credentials))
            WrapPadding {
                EniTextField(
                    value = loginRequestDataState.email,
                    onValueChange =  { value -> viewModel.loginRequestData.value = viewModel.loginRequestData.value.copy(email = value)},
                    hintText = stringResource(R.string.app_field_email_hint),
                    icon = Icons.Default.Email
                )
            }
            WrapPadding {
                EniTextField(
                    value = loginRequestDataState.password!!,
                    onValueChange =  { value -> viewModel.loginRequestData.value = viewModel.loginRequestData.value.copy(password = value)},
                    hintText = stringResource(R.string.app_field_password_hint),
                    icon = Icons.Default.Lock
                )
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_forget_password), onClick = {
                    navController.navigate("resetPassword")
                })
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_login), onClick = {
                    viewModel.callLoginRequest(onLoginSuccess = {
                        // ouvrir la page list article
                        AppViewHelper.openActivity(context, ArticleActivity::class)
                    })
                })
            }
            Spacer(modifier = Modifier.weight(1f))
            SecondaryTextInfo(stringResource(R.string.app_msg_ask_have_account))
            WrapPadding {
                EniButton(
                    buttonText = stringResource(R.string.app_btn_register_now), onClick =
                        {
                            navController.navigate("signUp")
                        })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()

    LoginPage(navController)
}