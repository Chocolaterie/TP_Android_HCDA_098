package com.example.androidtp.auth

import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignUpPage()
        }
    }
}

@Composable
fun SignUpPage() {
    EniPage {
        Column(modifier = Modifier.padding(40.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TitlePage(text = stringResource(R.string.app_title_signup), verticalPadding = 30.dp)
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_pseudo_hint))
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_email_hint))
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_password_hint))
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_password_confirm_hint))
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_city_hint))
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_city_code_hint))
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_phone_hint))
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_submit))
            }
        }
    }
}

@Composable
@Preview
fun SignUpPreview(){
    SignUpPage()
}