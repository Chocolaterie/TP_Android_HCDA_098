package com.example.androidtp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtp.R

/**
 * @Composable
 * fun EniTextField(hintText : String = "", modifier: Modifier = Modifier){
 *     TextField(value = "", onValueChange = {},
 *         modifier = modifier.fillMaxWidth(),
 *         colors = TextFieldDefaults.colors(
 *             unfocusedContainerColor = Color(0x66000000),
 *             focusedContainerColor = Color(0x99000000),
 *             unfocusedIndicatorColor = Color.Transparent,
 *             focusedIndicatorColor = Color.Transparent
 *         ),
 *         shape = RoundedCornerShape(40.dp),
 *         placeholder = {
 *             Text(text = hintText, color = Color(0xAAFFFFFF))
 *         })
 * }
 */

@Composable
fun ConditionalIcon(icon: ImageVector?) {
    icon?.let { Icon(imageVector = icon, contentDescription = null, tint = Color(0xAAFFFFFF)) }
}

@Composable
fun EniTextField(hintText : String = "", modifier: Modifier = Modifier, icon: ImageVector? = null){
    TextField(value = "", onValueChange = {},
        modifier = modifier.fillMaxWidth(),
        leadingIcon = { ConditionalIcon(icon) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x66000000),
            focusedContainerColor = Color(0x99000000),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40.dp),
        placeholder = {
            Text(text = hintText, color = Color(0xAAFFFFFF))
        })
}

@Composable
fun EniButton(buttonText : String, modifier: Modifier = Modifier){
    Button(onClick = {},
        border = BorderStroke(2.dp, Color(0x55FFFFFF)),
        contentPadding = PaddingValues(),
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(brush = Brush.linearGradient(
                listOf(Color(0xFF54668b), Color(0xFF4188b5))
            )).fillMaxWidth().padding(vertical = 14.dp)
        ) {
            Text(buttonText)
        }
    }
}

@Composable
fun WrapPadding(content: @Composable () -> Unit){
    Box(modifier = Modifier.padding(10.dp)) {
        content()
    }
}

@Composable
fun RowScope.WrapPaddingRowWeight(weight: Float = 1f, content: @Composable () -> Unit){
    Box(modifier = Modifier.padding(10.dp).weight(weight)) {
        content()
    }
}

@Composable
fun TitlePage(text: String, verticalPadding: Dp = 100.dp){
    Text(text, textAlign = TextAlign.Center, fontSize = 36.sp,
        color = Color(0xEEFFFFFF),
        fontWeight = FontWeight.Bold,
        style = TextStyle(
            shadow = Shadow(
                color = Color(0XFF98c0e3), offset = Offset(0f, 0f), blurRadius = 5f
            )
        ),
        modifier = Modifier.fillMaxWidth().padding(vertical = verticalPadding))
}

@Composable
fun SecondaryTextInfo(message: String){
    Text(
        message,
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic,
        color = Color(0xDDFFFFFF), style = TextStyle(
            shadow = Shadow(
                color = Color.Black, offset = Offset(1f, 1f), blurRadius = 0f,
            )
        ),)
}

@Composable
fun EniPage(content: @Composable () -> Unit){
    AndroidTPTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(R.drawable.mobile_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                content()
            }
        }
    }
}