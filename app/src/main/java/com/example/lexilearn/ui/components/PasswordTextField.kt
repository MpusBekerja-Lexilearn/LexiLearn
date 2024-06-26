package com.example.lexilearn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lexilearn.R

@Composable
fun PasswordTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    textPassword: String = stringResource(
        id = R.string.password
    )
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password), // Replace with your password icon drawable resource
                contentDescription = "Password Icon",
                tint = Color.Gray
            )
        },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = textPassword) },
        shape = RoundedCornerShape(8.dp),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisibility) {
                painterResource(id = R.drawable.ic_visibility) // Replace with your visibility on icon drawable resource
            } else {
                painterResource(id = R.drawable.ic_visibility_off) // Replace with your visibility off icon drawable resource
            }

            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(painter = image, contentDescription = "Toggle Password Visibility")
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
    )
}

@Preview
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextField(
        value = TextFieldValue(""),
        onValueChange = {},
        modifier = Modifier.padding(16.dp)
    )
}
