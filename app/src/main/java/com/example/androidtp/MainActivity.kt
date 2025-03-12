package com.example.androidtp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtp.ui.theme.AndroidTPTheme
import com.example.androidtp.ui.theme.EniButton
import com.example.androidtp.ui.theme.EniPage
import com.example.androidtp.ui.theme.EniTextField
import com.example.androidtp.ui.theme.SecondaryTextInfo
import com.example.androidtp.ui.theme.TitlePage
import com.example.androidtp.ui.theme.WrapPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPage()
        }
    }
}

@Composable
fun LoginPage() {
    EniPage {
        Column(modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.AccountCircle,
                modifier = Modifier.size(96.dp),
                contentDescription = null, tint = Color(0xDDFFFFFF))
            TitlePage(text = stringResource(R.string.app_title_login), verticalPadding = 30.dp)
            SecondaryTextInfo(stringResource(R.string.app_msg_info_please_aware_credentials))
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_email_hint),
                    icon = Icons.Default.Email)
            }
            WrapPadding {
                EniTextField(hintText = stringResource(R.string.app_field_password_hint),
                    icon = Icons.Default.Lock)
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_forget_password))
            }
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_login))
            }
            Spacer(modifier = Modifier.weight(1f))
            SecondaryTextInfo(stringResource(R.string.app_msg_ask_have_account))
            WrapPadding {
                EniButton(buttonText = stringResource(R.string.app_btn_register_now))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginPage()
}