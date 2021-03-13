/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun LoginPage(
    onLogin: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (
            spacerTop, title, spacer, input1, spacer2, input2, policy1, policy2,
            spacerBottom, loginButton
        ) = createRefs()

        Spacer(
            modifier = Modifier
                .height(184.dp)
                .fillMaxWidth()
                .constrainAs(spacerTop) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "Log in with email",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(spacerTop.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
                .constrainAs(spacer) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        var email: String by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email address") },
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onPrimary,
                focusedLabelColor = MaterialTheme.colors.onPrimary,
            ),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .constrainAs(input1) {
                    top.linkTo(spacer.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
                .constrainAs(spacer2) {
                    top.linkTo(input1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        var pass: String by remember { mutableStateOf("") }
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Password (8+ characters)") },
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onPrimary,
                focusedLabelColor = MaterialTheme.colors.onPrimary,
            ),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .constrainAs(input2) {
                    top.linkTo(spacer2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Row(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .constrainAs(policy1) {
                    top.linkTo(input2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            val annotatedString = buildAnnotatedString {
                append("By clicking below, you agree to our ")
                pushStyle(
                    SpanStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
                append("Terms of Use ")
                pop()
                append("and consent")
            }
            Text(
                text = annotatedString,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2
            )
        }

        val annotatedString = buildAnnotatedString {
            append("to our ")
            pushStyle(
                SpanStyle(
                    textDecoration = TextDecoration.Underline
                )
            )
            append("Privacy Policy")
            pop()
        }

        Text(
            text = annotatedString,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(policy2) {
                    top.linkTo(policy1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth()
                .constrainAs(spacerBottom) {
                    top.linkTo(policy2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Button(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(0.9F)
                .constrainAs(loginButton) {
                    top.linkTo(spacerBottom.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = {
                onLogin()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                text = "Log in",
                style = MaterialTheme.typography.button
            )
        }
    }
}
