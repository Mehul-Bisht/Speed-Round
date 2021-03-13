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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun HomePage(
    onNavigate: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageLeft) = createRefs()
            Image(
                painter = painterResource(getLeftId(isSystemInDarkTheme())),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(imageLeft) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageLeft, spacerLeft, spacerTop, title, spacerImageBottom, subtitle, subtitleBottom, button, logIn, lastSpacer) = createRefs()
            Spacer(
                modifier = Modifier
                    .width(88.dp)
                    .constrainAs(spacerLeft) {
                        start.linkTo(parent.start)
                    }
            )
            Spacer(
                modifier = Modifier
                    .height(72.dp)
                    .constrainAs(spacerTop) {
                        top.linkTo(parent.top)
                    }
            )
            Image(
                painter = painterResource(getId(isSystemInDarkTheme())),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(imageLeft) {
                        start.linkTo(spacerLeft.end)
                        top.linkTo(spacerTop.bottom)
                    }
            )
            Spacer(
                modifier = Modifier
                    .height(48.dp)
                    .constrainAs(spacerImageBottom) {
                        top.linkTo(imageLeft.bottom)
                    }
            )
            Image(
                painter = painterResource(id = getTitle(isSystemInDarkTheme())),
                contentDescription = "caption",
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(spacerImageBottom.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = "Beautiful home garden solutions",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .height(32.dp)
                    .padding(top = 8.dp)
                    .constrainAs(subtitle) {
                        top.linkTo(title.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .constrainAs(subtitleBottom) {
                        top.linkTo(subtitle.bottom)
                    }
            )
            Button(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(0.9F)
                    .constrainAs(button) {
                        top.linkTo(subtitleBottom.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Create account",
                    style = MaterialTheme.typography.button
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .constrainAs(lastSpacer) {
                        top.linkTo(button.bottom)
                    }
            )
            Text(
                text = "Log In",
                style = MaterialTheme.typography.button,
                color = getLoginColor(isSystemInDarkTheme()),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .constrainAs(logIn) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(lastSpacer.bottom)
                    }
                    .clickable(
                        onClick = {
                            onNavigate(Screens.loginScreen.route)
                        }
                    )
            )
        }
    }
}

fun getLoginColor(isDark: Boolean): Color {
    if (isDark)
        return white
    return pink900
}

fun getTitle(isDark: Boolean): Int {
    if (isDark) {
        return R.drawable.ic_dark_logo
    }
    return R.drawable.ic_light_logo
}

fun getLeftId(isDark: Boolean): Int {
    if (isDark) {
        return R.drawable.ic_dark_welcome_bg
    }
    return R.drawable.ic_light_welcome_bg
}

fun getId(isDark: Boolean): Int {
    if (isDark) {
        return R.drawable.ic_dark_welcome_illos
    }
    return R.drawable.ic_light_welcome_illos
}
