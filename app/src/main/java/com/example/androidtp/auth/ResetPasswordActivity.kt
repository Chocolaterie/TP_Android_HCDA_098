package com.example.androidtp.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidtp.R
import com.example.androidtp.ui.theme.EniButton
import com.example.androidtp.ui.theme.EniPage
import com.example.androidtp.ui.theme.EniTextField
import com.example.androidtp.ui.theme.SecondaryTextInfo
import com.example.androidtp.ui.theme.TitlePage
import com.example.androidtp.ui.theme.WrapPadding

@Composable
fun ResetPasswordPage() {

    val viewModel = AuthViewModel.get();

    // Ecouter en temps réel le changement de loginRequestData
    val loginRequestDataState by viewModel.loginRequestData.collectAsState()

    val context = LocalContext.current;

    EniPage(backgroundId = R.drawable.mobile_background_2) {
        Column(modifier = Modifier.padding(40.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TitlePage(text = stringResource(R.string.app_title_reset_password), verticalPadding = 60.dp)
            WrapPadding {
                EniTextField(
                    value = loginRequestDataState.email,
                    onValueChange =  { value -> viewModel.loginRequestData.value = viewModel.loginRequestData.value.copy(email = value)},
                    hintText = stringResource(R.string.app_field_email_hint), icon = Icons.Default.Email)
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_send),
                    onClick = {
                        viewModel.callResetPasswordRequest()
                    })
            }
            Spacer(modifier = Modifier.weight(1f))
            SecondaryTextInfo(stringResource(R.string.app_msg_info_dont_forget_password))
        }
    }
}

@Composable
@Preview
fun ResetPasswordPreview(){

    ResetPasswordPage()
}